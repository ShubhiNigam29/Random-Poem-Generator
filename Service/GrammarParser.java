package Service;

import GrammarRule.*;
import java.io.*;
import java.util.*;

public class GrammarParser {
	public Grammar readInputFile(String inputFile){

		File file = new File(inputFile);
		
		// Exit program if file doesn't exist
		if (!file.exists())
		{
			System.out.println("Input file" + inputFile + " doesn't exist!");
			System.exit(0);
		}
	
		// Create a Grammar object
		Grammar grammar= new Grammar();
		
		// Read the input file
		try {
			//FileInputStream fis = new FileInputStream(file);	
			//BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
	
			// Process the file line by line
			while (br.readLine() != null) {
				// Create a Rule object
				Rule rule= new Rule();
				
				// Read line and set Rule name
				// Get rule definition
				String line=br.readLine();
				String [] ruleString=line.split(":");
				String ruleName = ruleString[0].trim();
				String ruleDefinition = ruleString[1].trim();
				rule.setRuleName(ruleName);
				
				// Set the rules in grammar 
				if (grammar.getMainRule()==null){
					// It's main rule, set it
					grammar.setMainRule(ruleName);
					String [] referenceKeywords=ruleDefinition.trim().split(" ");
					List<String> ruleReferenceKeyword= new ArrayList<String>();	
					for (String referenceKeyword : referenceKeywords) {
						ruleReferenceKeyword.add(referenceKeyword);
					}
					rule.setKeywords(ruleReferenceKeyword);			
					
					grammar.getRules().put(ruleName, rule);					
				}
				else{
					// It's not a main rule, set it
					String[] ruleWordReferenceKeyword = ruleDefinition.split(" ");
					
					// Flag to decide which ruleWordReferenceKeyword is for References and Keywords
					int indexReferenceKeyword=0;
					
					// The rule has words
					if (ruleWordReferenceKeyword[0].matches("[a-z].*")){
						String [] words =ruleWordReferenceKeyword[0].trim().split("\\|");
						List<String> ruleWords= new ArrayList<String>();
					
						// Add words to the rule
						for (String word : words) {
							ruleWords.add(word);
						}
						rule.setWords(ruleWords);
						
						// Second entry of the ruleWordReferenceKeyword is for References and Keywords
						indexReferenceKeyword=1;	
					}
	
					// Get the References and Keywords and add them to the rule
					String [] referenceKeywords=ruleWordReferenceKeyword[indexReferenceKeyword].trim().split("\\|");
					List<String> ruleReferenceKeyword= new ArrayList<String>();	
					for (String referenceKeyword : referenceKeywords) {
						ruleReferenceKeyword.add(referenceKeyword);
					}
					rule.setKeywords(ruleReferenceKeyword);			
					
					// Add the rule to grammar
					grammar.getRules().put(ruleName, rule);	            
				}
			}
			
			// Done with reading, close resources
			//fis.close();
			//bis.close();
			br.close();
		} catch (IOException e) {
			System.out.println("Error reading input file.");
		}		  	  
		return grammar;		  	  
	}
}