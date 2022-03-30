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
import java.util.List;
import java.util.Scanner;



//import classes and functions
import compareDNA.runCompareDNA;
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;
import compareDNA.DNAstrand;

public class compareDNATest {
	
//	@Before
//	public void setup() throws IOException { //added throws IOException for error handling
//		
//		try {
//			Files.copy(new File("testFiles/test.dat.bak").toPath(), new File("testFiles/test.dat").toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			System.out.println("unable to copy files");
//			e.printStackTrace();
//		}
//		
//	}

//	@Test
//	public void test() {
//		assertEquals(1,1);
//	} 
	@Test
	public void testReadDNASequences() throws FileNotFoundException {
		
//		String[] dnaSequencesFilePathArray = {"testFiles/sameRandomDNASequences.txt"};
		
		//read in file path and collect output array containing dna sequences
		ArrayList<String> dnaSequencesArray = runCompareDNA.readDNAInputToArray("src/testFiles/sameRandomDNASequences.txt");
		
		//manually store dna strands from the inputed test file
		String trueDNASequence1 = "ATGCGATCGATCTAGATCGATATGCGATTCGATGCTTATATATAAAAGCGCTATAGCATCGATCGATCGATCAGG";
		String trueDNASequence2 = "ATGCGATCGATCTAGATCGATATGCGATTCGATGCTTATATATAAAAGCGCTATAGCATCGATCGATCGATCAGG";
		
		//check that the dna sequence array contains only 2 dna strands, otherwise raise an error
		assertTrue("DNA sequences array does not contain 2 DNA strands. Please check input file or function.", dnaSequencesArray.size() == 2);
		
		//check manually that the two strands being read in correspond to the dna sequences in the file
		assertTrue("The inputed first DNA sequence does not match the true first DNA sequence", dnaSequencesArray.get(0).equals(trueDNASequence1));
		assertTrue("The inputed second DNA sequence does not match the true second DNA sequence", dnaSequencesArray.get(1).equals(trueDNASequence2));
		
	}
	
	@Test
	public void testInputDNAValidation() throws FileNotFoundException {		

		//create a set of correct dna sequences
		ArrayList<String> correctDNASequences = new ArrayList<>();
		correctDNASequences.add("ATGCGATCGATCTAGATCGATATGCGATTCGATGCTTATATATAAAAGCGCTATAGCATCGATCGATCGATCAGG");
		correctDNASequences.add("ATGCGATCGATCTAGATCGATATGCGATTCGATGCTTATATATAAAAGCGCTATAGCATCGATCGATCGATCAGG");
		
		//create a set of incorrect dna sequences - contain characters that are not base pairs
		ArrayList<String> incorrectDNASequences = new ArrayList<>();
		incorrectDNASequences.add("ATGCGATCGATCTAGATCGATATGCZDZFDGTTCGATGCTTATATATAAAAGATAGCATCGATCGATCGATCAGG");
		incorrectDNASequences.add("ATGCGATCGATCTAGATCGATATGCGATTCGATGCTTATATATAADKFGBSCGCAGCATCGATCGATCGATCAGG");
		
		boolean correctDNAValidationOutput = runCompareDNA.validateInputDNASequences(correctDNASequences);
		boolean incorrectDNAValidationOutput = runCompareDNA.validateInputDNASequences(incorrectDNASequences);
		
		//check that correct and incorrect dna sequences raise an error indicated invalidity
		assertTrue("The correct DNA sequences are being evaluated as invalid.", correctDNAValidationOutput == false); //false: no error
		assertTrue("The incorrect DNA sequences are being evaluated as valid.", incorrectDNAValidationOutput == true);//true: there is an error in sequences
	}

	public void testComputeDNAStatistics() throws Exception {		

		//create a set of dna sequences containing only adenine nucleotides
		ArrayList<String> sampleDNASequencesPolyA = new ArrayList<>();
		sampleDNASequencesPolyA.add("AAAAAAAAAAAAAAA");
		sampleDNASequencesPolyA.add("AAAAAAAAAAAAAAA");

		//create a set of dna sequences containing half of one nucleotide and half of another
		ArrayList<String> sampleDNASequencesHalf = new ArrayList<>();
		sampleDNASequencesHalf.add("AAAAAAAAAAAAAAAGGGGGGGGGGGGGGG");
		sampleDNASequencesHalf.add("CCCCCCCCCCCCCCCTTTTTTTTTTTTTTT");
		
		//create a set of dna sequences containing equal percentages of each nucleotide
		ArrayList<String> sampleDNASequencesAllEqual = new ArrayList<>();
		sampleDNASequencesAllEqual.add("AAAAAAGGGGGGCCCCCCTTTTTT");
		sampleDNASequencesAllEqual.add("AAAAAAGGGGGGCCCCCCTTTTTT");
		
		//assume we have no error in the dna strands because the step comes prior to computing statistics
		boolean dnaStrandError = false;
		
		
		//compute statistics on various input lists generated above - order of nucleotide percentages: {A,T,C,G}
		List<List<Double>> dnaStatisticsListPolyA = runCompareDNA.computeDNAStatistics(dnaStrandError, sampleDNASequencesPolyA);
		List<List<Double>> dnaStatisticsListHalf = runCompareDNA.computeDNAStatistics(dnaStrandError, sampleDNASequencesHalf);
		List<List<Double>> dnaStatisticsListAllEqual = runCompareDNA.computeDNAStatistics(dnaStrandError, sampleDNASequencesAllEqual);
		
		//manually add percentages
		
		//poly adenine
		List<List<Double>> polyAStatisticsList = new ArrayList<>();
		List<Double> polyAStatistics = new ArrayList<>();
		polyAStatistics.add(1.0);
		polyAStatistics.add(1.0);
		polyAStatistics.add(1.0);
		polyAStatistics.add(1.0);
		polyAStatisticsList.add(polyAStatistics);
		polyAStatisticsList.add(polyAStatistics);
		
		//half
		List<List<Double>> halfStatisticsList = new ArrayList<>();
		List<Double> halfStatistics1 = new ArrayList<>();
		halfStatistics1.add(0.5);
		halfStatistics1.add(0.0);
		halfStatistics1.add(0.0);
		halfStatistics1.add(0.5);
		halfStatisticsList.add(halfStatistics1);
		
		List<Double> halfStatistics2 = new ArrayList<>();
		halfStatistics2.add(0.0);
		halfStatistics2.add(0.5);
		halfStatistics2.add(0.5);
		halfStatistics2.add(0.0);
		halfStatisticsList.add(halfStatistics2);
		
		//all equal
		List<List<Double>> allEqualStatisticsList = new ArrayList<>();
		List<Double> allEqualStatistics = new ArrayList<>();
		allEqualStatistics.add(0.25);
		allEqualStatistics.add(0.25);
		allEqualStatistics.add(0.25);
		allEqualStatistics.add(0.25);
		allEqualStatisticsList.add(allEqualStatistics);
		allEqualStatisticsList.add(allEqualStatistics);

		//check that correct and incorrect dna sequences raise an error indicated invalidity
		assertTrue("The nucleotide compositions of the poly A DNA Sequences are incorrect", polyAStatisticsList.equals(dnaStatisticsListPolyA)); 
		assertTrue("The nucleotide compositions of the half DNA Sequences are incorrect", halfStatisticsList.equals(dnaStatisticsListHalf));
		assertTrue("The nucleotide compositions of the equal DNA Sequences are incorrect", allEqualStatisticsList.equals(dnaStatisticsListAllEqual));

	}


}
