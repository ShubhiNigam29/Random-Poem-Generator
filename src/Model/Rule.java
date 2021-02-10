package Model;

import java.util.*;

// The Rule model defines rules to be followed by Poem Generator

public class Rule {
	private String ruleName;
	private List<String> words;
	private List<String> keywords;
	
	// Constructor
	public Rule(){
		
	}
	
	// Keywords
    public enum Keywords {
        $END("\r"), $LINEBREAK("\n");

        private String value;

        private Keywords(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }	
	
    // Getters and Setters
    
	public String getRuleName() {
		return ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public List<String> getWords() {
		return words;
	}
	
	public void setWords(List<String> words) {
		this.words = words;
	}
	
	public List<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

}
