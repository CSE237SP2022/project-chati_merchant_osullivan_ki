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
import compareDNA.readDNAInput;
import compareDNA.DNAstrand;
import compareDNA.transcription;
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;

//citations
//create mappings from input to output: https://www.baeldung.com/java-map-entry

public class runCompareDNA {
	
	
	public boolean validateTranscriptionResults(ArrayList<String> mRNASequencesArray) throws FileNotFoundException {
		int dnaStrandIndex = 1;
		boolean transcriptionOutputError = false;
		
		System.out.println("Validate Transcription Outputs");
		
		for (String mRNASequence : mRNASequencesArray) { //make sure that dna sequences have been stored in the array

			validateTranscriptionOutputs transcriptionValidator;
			transcriptionValidator = new validateTranscriptionOutputs();
			
			boolean isRNAValid = transcriptionValidator.validator(mRNASequence);
			
			if (isRNAValid) {
				System.out.printf("mRNA Sequence %d is Valid \n", dnaStrandIndex);
			}
			else {
				System.out.printf("mRNA Sequence %d is Not Valid. It contains the nucleotide T. \n", dnaStrandIndex);
				transcriptionOutputError = true;
			}
			dnaStrandIndex++;
			
		}
		return transcriptionOutputError;
	}
	
	public ArrayList<String> conductTranslation(boolean transcriptionOutputError, ArrayList<String> mRNASequencesArray) throws Exception {
		ArrayList<String> aminoAcidSequencesArray;
		if (!transcriptionOutputError) {
			int dnaStrandIndex = 1;			
			System.out.println("Conduct Translation from mRNA to Amino Acid Chain");			
			translation conductTranslation;
			conductTranslation = new translation();		
			aminoAcidSequencesArray = conductTranslation.translater(mRNASequencesArray);		
			for (String peptideChain : aminoAcidSequencesArray) {
				System.out.printf("Peptide Chain Sequence %d: %s \n", dnaStrandIndex, peptideChain);
			}
		}
		else {
			throw new Exception("There is an error in the outputed mRNA Sequences. Please review the mRNA strands prior to conducting translation.");
		}
		return aminoAcidSequencesArray;
	}

	// run program and call methods above sequentially
	public static void main(String[] args) throws Exception { //IOException added
		
		System.out.println("\n");
		
		//setup
		readDNAInput readInput = new readDNAInput();
		ArrayList<String> dnaSequencesArray = readDNAInput.readDNAInputToArray(args[0]);
		
		//output provided dna sequences
		int dnaStrandIndex = 0; 
		System.out.println("Provided DNA Sequences");
		for (String dnaSequence : dnaSequencesArray) {
			System.out.printf("DNA Sequence %d: %s \n", dnaStrandIndex, dnaSequence);
			dnaStrandIndex++;
		}
		System.out.println("\n");
		
		//validate dna input and compute dna statistics
		DNAstrand dnaInputValidation = new DNAstrand(dnaSequencesArray);
		
		//transcription
		transcription transcriptionModule = new transcription();
		ArrayList<String> mRNASequencesArray = transcriptionModule.transcription(dnaSequencesArray);
		System.out.println("\n");

		//transcription output validation
		boolean transcriptionOutputError =  validateTranscriptionResults(mRNASequencesArray);	
		System.out.println("\n");

		//translation
		ArrayList<String> aminoAcidSequencesArray = conductTranslation(transcriptionOutputError, mRNASequencesArray);

	}
	
	

}
