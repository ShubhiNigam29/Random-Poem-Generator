package Service;

import Model.*;

import java.util.*;

public class RandomPoemGenerator {
	public void generatePoem(Grammar grammar){

		// Get the main/starting rule
        Rule mainRule = grammar.getRules().get(grammar.getMainRule());
        
        // Get the references to be executed by the main rule
        List<Rule> ruleQueues= new ArrayList<Rule>();
        for(String ruleName: mainRule.getKeywords()){     	
        	ruleQueues.add(grammar.getRules().get(ruleName.substring(1, ruleName.length() - 1)));
        }
        
        // Execute references
        for(Rule rule: ruleQueues){
        	ruleOutput(rule, grammar);
        }
	}
	
    private static void ruleOutput(Rule rule, Grammar grammar) {
    	
    	// If the rule has words, print a random one 
    	if (rule.getWords()!=null){
	        List<String> words = rule.getWords();
	        int random = getRandomNumber(0, words.size());
	        String word = words.get(random);
	        System.out.print(word+" "); 
    	}
    	
    	// Get a random keywords
        List<String> Keywords=rule.getKeywords();
        int random = getRandomNumber(0, Keywords.size());
        String keyString = Keywords.get(random);
        
        if (keyString.matches("<[A-Z]+>")) {
        	// The random selection is a Rule
        	// Execute the rule
        	Rule nextRule = grammar.getRules().get(keyString.substring(1, keyString.length() - 1));
        	ruleOutput(nextRule, grammar);
        }
        else {
        	// The random selection is a Keyword
        	// Print it
        	Rule.Keywords valueOf = Rule.Keywords.valueOf(keyString);
        	System.out.print(valueOf.getValue());
        }
    }
    
    // Method to generate random numbers in a range
    private static int getRandomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
