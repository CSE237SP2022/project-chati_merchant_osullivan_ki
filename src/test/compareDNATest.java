package test;

//import packages testing modules
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


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

	
	@Test
	void testReadDNASequences() throws IOException {
//		runCompareDNA readInputDNASequences;
//		readInputDNASequences = new runCompareDNA();
		
		String[] dnaSequencesFilePathArray = {"testFiles/sameRandomDNASequences.txt"};

		runCompareDNA.main(dnaSequencesFilePathArray);
		

		
//		Scanner dnaSequenceInputFile = new Scanner(new File(args[0]));
//		String sentence = "The quick brown fox ran up the tree.";
//		String[] splitSentence = sentence.split(" ");
		assertEquals(8, 9); //account for duplicate words - do we account for duplicate words initially?
	}
	
//	@Test
//	void testFileImportation2() {
//	
//	}


}
