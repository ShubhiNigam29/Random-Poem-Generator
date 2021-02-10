package Service;

import Model.*;
import java.io.*;
import java.util.*;

public class GrammerRulesParser {
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
			FileInputStream fis = new FileInputStream(file);	
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
	
			// Process the file line by line
			while (dis.available() != 0) {
				Rule rule= new Rule();
				// Read line and set Rule name
				// Get rule definition
				String line=dis.readLine();
				String [] ruleString=line.split(":");
				String ruleName = ruleString[0].trim();
				String ruleDefinition = ruleString[1].trim();
				rule.setRuleName(ruleName);
				
				// Set the rules in grammar 
				if (grammar.getMainRule()==null){
					// It's main rule, set it
					grammar.setMainRule(ruleName);
					String [] keywords=ruleDefinition.trim().split(" ");
					List<String> ruleKeyword= new ArrayList<String>();	
					for (String keyword : keywords) {
						ruleKeyword.add(keyword);
					}
					rule.setKeywords(ruleKeyword);			
					
					grammar.getRules().put(ruleName, rule);					
				}
				else{
					// It's not a main rule, set it
					String[] ruleWordKeyword = ruleDefinition.split(" ");
					
					// Flag to decide which ruleWordKeyword is for Keywords
					int indexKeyword=0;
					
					// The rule has words
					if (ruleWordKeyword[0].matches("[a-z].*")){
						String [] words =ruleWordKeyword[0].trim().split("\\|");
						List<String> ruleWords= new ArrayList<String>();
					
						// Add words to the rule
						for (String word : words) {
							ruleWords.add(word);
						}
						rule.setWords(ruleWords);
						
						// Second entry of the ruleWordKeyword is for Keywords
						indexKeyword=1;	
					}
	
					// Get the Keywords and add them to the rule
					String [] keywords=ruleWordKeyword[indexKeyword].trim().split("\\|");
					List<String> ruleKeyword= new ArrayList<String>();	
					for (String keyword : keywords) {
						ruleKeyword.add(keyword);
					}
					rule.setKeywords(ruleKeyword);					
					// Add the rule to grammar
					grammar.getRules().put(ruleName, rule);	            
				}
			}
			
			// Done with reading, close resources
			fis.close();
			bis.close();
			dis.close();
		} catch (IOException e) {
			System.out.println("Error reading input file!");
		}		  	  
		return grammar;		  	  
	}
}
