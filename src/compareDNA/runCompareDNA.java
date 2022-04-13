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
import compareDNA.DNAstrand;
import compareDNA.readDNAInput;

//citations
//create mappings from input to output: https://www.baeldung.com/java-map-entry

public class runCompareDNA {
	
//	public boolean validateInputDNASequences(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
//		int dnaStrandIndex = 1;
//		boolean dnaStrandError = false;
//		System.out.println("Evaluate Inputed DNA Sequences");
//		for (String dnaSequence : dnaSequencesArray) {
//			DNAstrand dnaInputValidation;
//			dnaInputValidation = new DNAstrand(dnaSequence);
//			boolean isDNAValid = dnaInputValidation.validateDNAinput();
//			if (isDNAValid) {
//				System.out.printf("DNA Sequence %d is Valid \n", dnaStrandIndex);
//			}
//			else {
//				System.out.printf("DNA Sequence %d is Not Valid. Please check that the inputed sequence is DNA. \n", dnaStrandIndex);
//				dnaStrandError = true;
//			}
//			dnaStrandIndex++;
//		}
//		return dnaStrandError;
//	}
	
//	public List<List<Double>> computeDNAStatistics(boolean dnaStrandError, ArrayList<String> dnaSequencesArray) throws Exception {
//		System.out.println("Compute DNA Sequence Length Nucleotide Composition");
//		List<List<Double>> nucleotideCompositionsList = new ArrayList<>();
//		
//		int dnaStrandIndex = 1;
//		if (!dnaStrandError) {
//			for (String dnaSequence : dnaSequencesArray) {
//				DNAstrand dnaStatistics;
//				dnaStatistics = new DNAstrand(dnaSequence);				
//				List<Double> nucleotideCompositions = new ArrayList<>();
//				
//				System.out.printf("DNA Sequence %d Length: %d \n", dnaStrandIndex, dnaStatistics.lengthDNA);
//				double percentageA = dnaStatistics.percentageA;
//				double percentageT = dnaStatistics.percentageT;
//				double percentageC = dnaStatistics.percentageC;
//				double percentageG = dnaStatistics.percentageG;
//				System.out.printf("DNA Sequence %d Nucleotide Composition: A: %f | T: %f | C: %f | G: %f  \n", dnaStrandIndex, percentageA, percentageT, percentageC, percentageG);
//				dnaStrandIndex++;
//
//				nucleotideCompositions.add(percentageA);
//				nucleotideCompositions.add(percentageT);
//				nucleotideCompositions.add(percentageC);
//				nucleotideCompositions.add(percentageG);
//				
//				nucleotideCompositionsList.add(nucleotideCompositions);
//			}
//			
//		}
//		else {
//			throw new Exception("There is an error in the provided DNA sequences. Please review the input files prior to conducting transcription.");
//		}
//		
//		return nucleotideCompositionsList;
//	}
	
	
	public ArrayList<String> conductTranscription(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
		ArrayList<String> mRNASequencesArray = new ArrayList<>();
		int dnaStrandIndex = 1;
		System.out.println("Conduct Transcription to mRNA");
		for (String dnaSequence : dnaSequencesArray) {
			DNAstrand transcriptionModule;
			transcriptionModule = new DNAstrand(dnaSequence);
			
			String mRNASequence = transcriptionModule.DNAtomRNA();
			mRNASequencesArray.add(mRNASequence);
			
			System.out.printf("DNA Sequence %d: %s \n", dnaStrandIndex, dnaSequence);
			System.out.printf("RNA Sequence %d: %s \n", dnaStrandIndex, mRNASequence);
			dnaStrandIndex++;
		}
		return mRNASequencesArray;
	}
	
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
		
		readDNAInput readInput = new readDNAInput();
		
		//setup
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
		
//		//dna input validation
//		boolean dnaStrandError = dnaInputValidation(dnaSequencesArray);
//		System.out.println("\n");
//		
//		//compute dna statistics
//		List<List<Double>> dnaStatisticsList = computeDNAStatistics(dnaStrandError, dnaSequencesArray);
//		System.out.println("\n");
//		
		//transcription
		ArrayList<String> mRNASequencesArray = conductTranscription(dnaSequencesArray);
		System.out.println("\n");

		//transcription output validation
		boolean transcriptionOutputError =  validateTranscriptionResults(mRNASequencesArray);	
		System.out.println("\n");

		//translation
		ArrayList<String> aminoAcidSequencesArray = conductTranslation(transcriptionOutputError, mRNASequencesArray);

	}
	
	

}
