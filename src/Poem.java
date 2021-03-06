import Model.*;
import Service.GrammerRulesParser;
import Service.RandomPoemGenerator;

public class Poem {

	public static void main(String[] args) {
		// Input file name
		final String inputFile = "C:\\Users\\shubh\\Documents\\GitHub\\Random-Poem-Generator\\GrammarRules.txt";
		
		// Read the input file and parse the grammar
		GrammerRulesParser grammerRulesParser= new GrammerRulesParser();
		Grammar grammar= grammerRulesParser.readInputFile(inputFile);
		
		// Generate a random poem using the grammar
		RandomPoemGenerator randomPoemGenerator= new RandomPoemGenerator();
		randomPoemGenerator.generatePoem(grammar);
		
	}

}
