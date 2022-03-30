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
	
	public static ArrayList<String> readDNAInputToArray(String filePath) throws FileNotFoundException {
		ArrayList<String> dnaSequencesArray = new ArrayList<String>(); //create array list for the dna sequences
		Scanner dnaSequenceInputFile = new Scanner(new File(filePath)); //read the sequences through the command line
		while (dnaSequenceInputFile.hasNextLine()) {
			String dnaSequence = dnaSequenceInputFile.nextLine(); //store each next dna sequence in the array
			dnaSequencesArray.add(dnaSequence); //store each next dna sequence in the array
		}
		return dnaSequencesArray;
	}

	public static void main(String[] args) throws IOException { //IOException added
		
		//setup
		
		ArrayList<String> dnaSequencesArray = readDNAInputToArray(args[0]);
		
		
		//transcription
		
		validateTranscriptionOutputs transcriptionValidator;
		
		transcriptionValidator = new validateTranscriptionOutputs();
		
		for (String dnaSequence : dnaSequencesArray) { //make sure that dna sequences have been stored in the array
			int isDNAValid = transcriptionValidator.validator(dnaSequence);
			System.out.println(isDNAValid);
		}
		
		
		//translation test
		
		List<Map.Entry<String, String>> codonAminoAcidMap = new ArrayList<>();
		
		Scanner aminoAcidsDictionary = new Scanner(new File("compareDNA/aminoAcidsDictionary.txt")); //CHANGE this to run from src
		
		while (aminoAcidsDictionary.hasNextLine()) {
			String codonAminoAcidMapping = aminoAcidsDictionary.nextLine(); //store each next dna sequence in the array
			String[] codonToAminoAcidArray = codonAminoAcidMapping.split("\\s+");
			String codon = codonToAminoAcidArray[0];
			String aminoAcid = codonToAminoAcidArray[2];
			Map.Entry<String, String> codonToAminoAcidEntry = new AbstractMap.SimpleEntry<>(codon, aminoAcid);
			codonAminoAcidMap.add(codonToAminoAcidEntry);
		}

    	ArrayList<String> aminoAcidSequencesStringArray = new ArrayList<String>();
    	
	    for (String dnaSequence : dnaSequencesArray) { 
	    	List<String> dnaCodonsArray = new ArrayList<String>();
	    	for (int i = 0; i < dnaSequence.length(); i += 3) {
	 	      String newTestLine = dnaSequence.substring(i);
	 	      String codon = newTestLine.substring(0, 3);
	 	      dnaCodonsArray.add(codon);
	    	}
	    	
	    	ArrayList<String> aminoAcidSequencesCharArray = new ArrayList<String>();
	    	
	    	for (String codon : dnaCodonsArray) {
	    		for (Map.Entry<String, String> codonEntry : codonAminoAcidMap) {
	    			String mRNACodonEntry = codonEntry.getKey().replace('T', 'U');
		            if (mRNACodonEntry.equals(codon)) {
		            	aminoAcidSequencesCharArray.add(codonEntry.getValue());
		            }
		        }	    		
	    	}
	    	
	    	StringBuilder aminoAcidPeptideChainBuilder = new StringBuilder();
	    	
	    	for(String aminoAcid : aminoAcidSequencesCharArray) {
	    		aminoAcidPeptideChainBuilder.append(aminoAcid);
	    	}
	    	
	    	String aminoAcidPeptideChain = aminoAcidPeptideChainBuilder.toString();
	    	aminoAcidSequencesStringArray.add(aminoAcidPeptideChain);
	    	
	    	System.out.println(aminoAcidPeptideChain);
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
