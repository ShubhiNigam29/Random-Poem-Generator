package Model;

import java.util.*;

// Describes the grammar rules

public class Grammar {
	private String mainRule;
	private Map<String,Rule> rules;
	
	// Constructor
	public Grammar(){
		
	}
	
	// Getters and Setters
	
	public String getMainRule() {
		return mainRule;
	}
	
	public void setMainRule(String mainRule) {
		this.mainRule = mainRule;
	}
	
	public Map<String,Rule> getRules() {
		if (this.rules==null){
			rules = new HashMap<String, Rule>();
		}
		return rules;
	}
	
	public void setRules(Map<String,Rule> rules) {
		this.rules = rules;
	}
}
