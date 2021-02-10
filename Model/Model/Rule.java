package Model;

import java.util.List;

// Rule defines the rules followed by Poem Generator

public class Rule {
	private String ruleName;
	private List<String> words;
	private List<String> keys;
	
	// Constructor
	public Rule(){
		this.ruleName = "";
		this.words = null;
		this.keys = null;
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
		return keys;
	}
	
	public void setKeywords(List<String> keys) {
		this.keys = keys;
	}

}