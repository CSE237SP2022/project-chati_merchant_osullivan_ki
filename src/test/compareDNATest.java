package test;

//import packages testing modules
//import static org.junit.platform.engine.ConfigurationParameters;
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
import java.util.Scanner;
//import org.junit.jupiter.api.Test;



//import classes and functions
import compareDNA.runCompareDNA;
import compareDNA.validateTranscriptionOutputs;
import compareDNA.translation;

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
	
//	@Test
//	public void testFileImportation2() {
//	
//	}


}
