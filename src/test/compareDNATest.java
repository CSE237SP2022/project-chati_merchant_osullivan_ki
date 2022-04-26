package test;

//import packages testing modules
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



//import classes and functions
import compareDNA.runCompareDNA;
import compareDNA.readDNAInput;
import compareDNA.DNAstrand;
import compareDNA.transcription;
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;


public class compareDNATest {
	
	//create a set of variables to be defined during the setup
	private String sampleDNASequence;
	private String invalidDNASequence;
	private String sampleRNASequence;
	private String samplePeptideChain;
	private ArrayList<String> sampleDNASequencesArray;
	private ArrayList<String> invalidDNASequencesArray;
	private ArrayList<Integer> sampleDNALengthsArray;
	private List<Double> sampleDNASequenceStatistics;
	private List<List<Double>> sampleDNAStatisticsArray;
	private ArrayList<String> sampleRNASequencesArray;
	private ArrayList<String> samplePeptideSequencesArray;
	
	//setup - create a set of sample dna and mrna sequences that can be used repeatedly for testing purposes and predefine outputs from methods we are testing
	@Before
	public void setup() {
		sampleDNASequence = "AAAAAATTTTTTCCCCCCGGGGGG";
		invalidDNASequence = "AAAAAATSDFGSTTGGGGGSDFCD";
		sampleRNASequence = "UUUUUUAAAAAAGGGGGGCCCCCC";
		samplePeptideChain = "FFKKGGPP";
		
		//create array for sample and invalid dna sequences
		sampleDNASequencesArray = new ArrayList<String>(Arrays.asList(sampleDNASequence,sampleDNASequence));
		invalidDNASequencesArray = new ArrayList<String>(Arrays.asList(invalidDNASequence,invalidDNASequence));
		
		//create array containing lengths of sample sequences
		sampleDNALengthsArray = new ArrayList<Integer>(Arrays.asList(24,24));
		
		//create array containing statistics for sample dna sequences
		sampleDNASequenceStatistics = new ArrayList<Double>(Arrays.asList(0.25,0.25,0.25,0.25));
		sampleDNAStatisticsArray = new ArrayList<List<Double>>(Arrays.asList(sampleDNASequenceStatistics,sampleDNASequenceStatistics));
		
		//create array for mrna sequences generated through transcription
		sampleRNASequencesArray = new ArrayList<String>(Arrays.asList(sampleRNASequence,sampleRNASequence));
		
		//create sample translation output
		samplePeptideSequencesArray = new ArrayList<String>(Arrays.asList(samplePeptideChain,samplePeptideChain));

	}
	
	
	//Class: readDNAInput
	
	//Method: readDNAInputToArray - check if sequences are being read in properly from the text file inputs
	@Test
	public void testReadDNASequences() throws FileNotFoundException {
		
//		String[] dnaSequencesFilePathArray = {"testFiles/sameRandomDNASequences.txt"};
		
		//read in file path and collect output array containing dna sequences
		readDNAInput readInput = new readDNAInput();
		ArrayList<String> dnaSequencesArray = readDNAInput.readDNAInputToArray("src/testFiles/sameShortDNASequences.txt");
						
		//check that the dna sequence array contains only 2 dna strands, otherwise raise an error
		assertTrue("DNA sequences array does not contain 2 DNA strands. Please check input file or function.", dnaSequencesArray.size() == 2);
		
		//check manually that the two strands being read in correspond to the dna sequences in the file
		assertTrue("The inputed first DNA sequence does not match the true first DNA sequence", dnaSequencesArray.get(0).equals(sampleDNASequence));
		assertTrue("The inputed second DNA sequence does not match the true second DNA sequence", dnaSequencesArray.get(1).equals(sampleDNASequence));
	}
	
	//Class: DNAstrand
	
	//Method: validateDNAinput - check that the dna inputs are being validated properly
	@Test
	public void testInputDNAValidation() throws FileNotFoundException {		
		
		//validate dna input based on sample and invalid dna sequences defined during the setup
		DNAstrand dnaInputValidation = new DNAstrand();
		boolean correctDNAValidationOutput = dnaInputValidation.validateDNAinput(sampleDNASequencesArray);
		boolean incorrectDNAValidationOutput = dnaInputValidation.validateDNAinput(invalidDNASequencesArray);
		
		//check that correct and incorrect dna sequences raise an error indicated invalidity
		assertTrue("The correct DNA sequences are being evaluated as invalid.", correctDNAValidationOutput == true); 
		assertTrue("The incorrect DNA sequences are being evaluated as valid.", incorrectDNAValidationOutput == false);
	}

	//Method: computeDNALengths - see if the lengths of each DNA sequence are properly returned
	@Test
	public void testComputeDNALengths() throws Exception {	
		
		//run compute lengths method
		ArrayList<Integer> testDNALengthsArray;
		DNAstrand computeSequenceLengthsModule = new DNAstrand();
		testDNALengthsArray = computeSequenceLengthsModule.computeDNALengths(sampleDNASequencesArray);
		
		//compare outputs to ground truth lengths defined in the setup
		assertTrue("The DNA sequence lengths are incorrect.", sampleDNALengthsArray.equals(testDNALengthsArray)); 

		
	}
	
	//Method: calculateDNAstats - check dna statistics when we use arrays of mixed dna base pairs
	@Test
	public void testComputeDNAStatistics() throws Exception {		
		
		//assume we have no error in the dna strands because the step comes prior to computing statistics
		boolean isDNAValid = true;
		
		//compute statistics on various input lists generated above - order of nucleotide percentages: {A,T,C,G}
		DNAstrand computeDNAPercentages = new DNAstrand();
		List<List<Double>> testDNAStatisticsArray = computeDNAPercentages.calculateDNAstats(sampleDNASequencesArray);
						
		//check that correct and incorrect dna sequences raise an error indicated invalidity
		assertTrue("The nucleotide compositions of the equal DNA Sequences are incorrect", sampleDNAStatisticsArray.equals(testDNAStatisticsArray));
	}
	
	//Class: transcription
	
	//Method: conductTranscription - check that the dna sequences are being converted to mrna sequences
	@Test
	public void testConductTranscription() throws Exception {
				
		//conduct transcription on sample dna sequences
		transcription transcriptionModule = new transcription();
		ArrayList<String> transcriptionOutputs = transcriptionModule.conductTranscription(sampleDNASequencesArray);
		
		//check outputs
		assertTrue("Transcription was not conducted carefully. Please check the outputs.", sampleRNASequencesArray.equals(transcriptionOutputs)); 
		
	} 
	
	@Test
	public void testValidateTranscriptionOuputs() throws Exception {
		
		//run transcription validation on rna and dna sequences
		validateTranscriptionOutputs transcriptionValidation = new validateTranscriptionOutputs();
		boolean correctRNAValidationOutput = transcriptionValidation.validator(sampleRNASequencesArray);
		boolean incorrectRNAValidationOutput = transcriptionValidation.validator(sampleDNASequencesArray);
		
		//check that incorrect mrna sequences can be properly detected
		assertTrue("The DNA sequences were properly transcribed to mRNA.", correctRNAValidationOutput == true); 
		assertTrue("The DNA sequences were not properly transcribed to mRNA.", incorrectRNAValidationOutput == false);
	} 
	
	@Test
	public void testConductTranslation() throws Exception {
		
		//assume valid mrna
		boolean isRNAValid = true;
		
		//conduct translation on sample rna sequences
		translation translationModule = new translation();
		String aminoAcidDictionaryPath = "src/compareDNA/aminoAcidsDictionary.txt";
		ArrayList<String> aminoAcidSequences = translationModule.translater(sampleRNASequencesArray, isRNAValid, aminoAcidDictionaryPath);
	
		//check that translation worked properly
		assertTrue("The mRNA sequences were not properly translated to amino acids.", samplePeptideSequencesArray.equals(aminoAcidSequences));

	} 

	@Test 
	public void testShortDNASequence() throws Exception {
		//Setup a DNA strand sequence
		String DNASequenceTest = "ATCGACGACTGATCGATCGTACGTACGTA";

		//Create a smaller strand from the larger strand
		String subString = "CGACGAC";

		//Check that the method found the location in the correct spot.
		assertTrue("The location of the substring was not found", locationDNA(DNASequenceTest, subString).equals(2));
	}


}
