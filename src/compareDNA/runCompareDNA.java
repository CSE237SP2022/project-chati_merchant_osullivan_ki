package compareDNA;
import java.io.*; //read file inputs and generate outputs
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//import classes to run pairwise analysis
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;

public class runCompareDNA {

	public static void main(String[] args) throws IOException { //IOException added
		
		ArrayList<String> dnaSequencesArray = new ArrayList<String>(); //create array list for the dna sequences

		
		Scanner dnaSequenceInputFile = new Scanner(new File(args[0])); //read the sequences through the command line
		
		while (dnaSequenceInputFile.hasNextLine()) {
			String dnaSequence = dnaSequenceInputFile.nextLine(); //store each next dna sequence in the array
			dnaSequencesArray.add(dnaSequence); //store each next dna sequence in the array
		}
		
//		for (String dnaSequence : dnaSequencesArray) { //make sure that dna sequences have been stored in the array
//			System.out.println(dnaSequence);
//		}
		
		
		validateTranscriptionOutputs transcriptionValidator;
		
		transcriptionValidator = new validateTranscriptionOutputs();
		
		for (String dnaSequence : dnaSequencesArray) { //make sure that dna sequences have been stored in the array
			int isDNAValid = transcriptionValidator.validator(dnaSequence);
			System.out.println(isDNAValid);
		}
		
		translation conductTranslation;
		
		conductTranslation = new translation();
		
//		for (String dnaSequence : dnaSequencesArray) { 
//			String[] mRNASequenceArray = conductTranslation.translater(dnaSequence); //translate dna to mrna
//			for (String mRNASequence : mRNASequenceArray) {
//				System.out.println(mRNASequence);
//			}
			//			String mRNASequence = mRNASequenceArray.toString(); //convert dna sequence array to a string
//			System.out.println(mRNASequence);
		}


		
		
		

	}

}
