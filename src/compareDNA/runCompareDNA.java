package compareDNA;
import java.io.*; //read file inputs and generate outputs
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class runCompareDNA {

	public static void main(String[] args) throws IOException { //IOException added
		
		ArrayList<String> dnaSequencesArray = new ArrayList<String>(); //create array list for the dna sequences

		
		Scanner dnaSequenceInputFile = new Scanner(new File(args[0])); //read the sequences through the command line
		
		while (dnaSequenceInputFile.hasNextLine()) {
			String dnaSequence = dnaSequenceInputFile.nextLine(); //store each next dna sequence in the array
			dnaSequencesArray.add(dnaSequence); //store each next dna sequence in the array
		}
		
		for (String dnaSequence : dnaSequencesArray) { //make sure that dna sequences have been stored in the array
			System.out.println(dnaSequence);
		}
		
		

	}

}
