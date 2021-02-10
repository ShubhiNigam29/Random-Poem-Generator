import Model.*;
import Service.GrammarParser;
import Service.PoemGenerator;

public class Poem {

	public static void main(String[] args) {
		// Input file name
		String INPUT_FILE_NAME = "GrammarRules.txt";
		
		// Read the input file and parse the grammar
		GrammarParser grammerParser= new GrammarParser();
		Grammar grammar= grammerParser.readInputFile(INPUT_FILE_NAME);
		
		// Generate a random poem using the grammar
		PoemGenerator poemGenerator= new PoemGenerator();
		poemGenerator.generatePoem(grammar);
		
	}

}
