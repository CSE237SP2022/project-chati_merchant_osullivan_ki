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
import compareDNA.pairwiseComparison;

//citations
//create mappings from input to output: https://www.baeldung.com/java-map-entry

public class runCompareDNA {

	// run program and call methods above sequentially
	public static void main(String[] args) throws Exception { //IOException added
		
		System.out.println("\n");
		
		//read and print dna sequences
		readDNAInput readInput = new readDNAInput();
		ArrayList<String> dnaSequencesArray = readDNAInput.readDNAInputToArray(args[0]);
		System.out.println("\n");
		
		//validate dna input and compute dna statistics
		DNAstrand dnaInputValidation = new DNAstrand();
		dnaInputValidation.runDNAstrand(dnaSequencesArray);
		System.out.println("\n");
		
		//find longest subsequence
		DNAstrand findKMer = new DNAstrand();
		String longestKMerDNASeq1 = findKMer.substringFrequency(dnaSequencesArray.get(0));
		System.out.println("\n");
		String longestKMerDNASeq2 = findKMer.substringFrequency(dnaSequencesArray.get(0));
		System.out.println("\n");
		
		//conduct transcription
		transcription transcriptionModule = new transcription();
		ArrayList<String> mRNASequencesArray = transcriptionModule.conductTranscription(dnaSequencesArray);
		System.out.println("\n");

		//validate transcription outputs
		validateTranscriptionOutputs transcriptionValidator = new validateTranscriptionOutputs();
		boolean isRNAValid =  transcriptionValidator.validator(mRNASequencesArray);	
		System.out.println("\n");

		//translation
		translation translationModule = new translation();
		String aminoAcidDictionaryPath = "compareDNA/aminoAcidsDictionary.txt";
		ArrayList<String> aminoAcidSequencesArray = translationModule.translater(mRNASequencesArray, isRNAValid, aminoAcidDictionaryPath);
		System.out.println("\n");
		
		//run similarity checker between amino acids
		pairwiseComparison aminoAcidSimilarityScore = new pairwiseComparison();
		aminoAcidSimilarityScore.similarityChecker(aminoAcidSequencesArray);
		System.out.println("\n");

	}
	

}
