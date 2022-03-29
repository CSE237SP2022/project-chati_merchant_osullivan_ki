package compareDNA;
import java.io.*; //read file inputs and generate outputs
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//import classes to run pairwise analysis
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;

//citations
//create mappings from input to output: https://www.baeldung.com/java-map-entry

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
		
		Set<String> aminoAcidsDictionary = new HashSet<>(Files.readAllLines(Paths.get("compareDNA/aminoAcidsDictionary.txt"))); //CHANGE this to run from src
		
		List<Map.Entry<String, String>> codonAminoAcidMap = new ArrayList<>();

		
				
//		for (Map.Entry<Integer,Field> tupleDescriptor : tupleDescriptors) {
//			tupleString.append(tupleDescriptor.getValue());
//		}
		
		for (String codonAminoAcidMapping : aminoAcidsDictionary) {
			String[] codonToAminoAcidArray = codonAminoAcidMapping.split("\\s+");
			String codon = codonToAminoAcidArray[0];
			String aminoAcid = codonToAminoAcidArray[1];
			Map.Entry<String, String> codonToAminoAcidEntry = new AbstractMap.SimpleEntry<>(codon, aminoAcid);
			codonAminoAcidMap.add(codonToAminoAcidEntry);
//			System.out.println(codonToAminoAcidEntry);
		}
		
		
//		List<String> codonList = new ArrayList<String>();

//	    	    System.out.println(codonList);
	    
	    for (String dnaSequence : dnaSequencesArray) { //make sure that dna sequences have been stored in the array
	    	 for (int i = 0; i < dnaSequence.length(); i += 3) {
	 	        String newTestLine = dnaSequence.substring(i);
	 	        String codon = newTestLine.substring(0, 3);
//	 	        codonList.add(codon);
	 	       System.out.println(codon);
	 	    }

	    }

				
//		translation conductTranslation;
//		
//		conductTranslation = new translation();

		
//		for (String dnaSequence : dnaSequencesArray) { 
//			String[] mRNASequenceArray = conductTranslation.translater(dnaSequence); //translate dna to mrna
//			for (String mRNASequence : mRNASequenceArray) {
//				System.out.println(mRNASequence);
//			}
			//			String mRNASequence = mRNASequenceArray.toString(); //convert dna sequence array to a string
//			System.out.println(mRNASequence);
//		}


		
		
		

	}

}
