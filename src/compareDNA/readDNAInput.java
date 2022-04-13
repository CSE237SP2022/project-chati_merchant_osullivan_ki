package compareDNA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readDNAInput {

	public static ArrayList<String> readDNAInputToArray(String filePath) throws FileNotFoundException {
		ArrayList<String> dnaSequencesArray = new ArrayList<String>(); //create array list for the dna sequences
		Scanner dnaSequenceInputFile = new Scanner(new File(filePath)); //read the sequences through the command line
		while (dnaSequenceInputFile.hasNextLine()) {
			String dnaSequence = dnaSequenceInputFile.nextLine(); //store each next dna sequence in the array
			dnaSequencesArray.add(dnaSequence); //store each next dna sequence in the array
		}
		return dnaSequencesArray;
	}
}
