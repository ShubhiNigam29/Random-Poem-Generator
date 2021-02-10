package Model;

import java.util.HashMap;
import java.util.Map;

// Grammar defines the rules followed by the poem generator

public class Grammar {
	private String mainRule;
	private Map<String,Rule> rules;
	
	// Constructor
	public Grammar(){
		this.mainRule = "";
        this.rules = null;
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
