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

	public static void main(String[] args) throws Exception { //IOException added
		
		System.out.println("\n");
		
		//setup
		
		ArrayList<String> dnaSequencesArray = readDNAInputToArray(args[0]);
		
		//output provided dna sequences
		
		int dnaStrandIndex = 1; 
		
		System.out.println("Provided DNA Sequences");
		
		for (String dnaSequence : dnaSequencesArray) {
			System.out.printf("DNA Sequence %d: %s \n", dnaStrandIndex, dnaSequence);
			dnaStrandIndex++;
		}

		System.out.println("\n");
		
		//dna input validation
		
		dnaStrandIndex = 1;
		boolean dnaStrandError = false;
		
		System.out.println("Evaluate Inputed DNA Sequences");
		
		for (String dnaSequence : dnaSequencesArray) {
			DNAstrand dnaInputValidation;
			dnaInputValidation = new DNAstrand(dnaSequence);
			boolean isDNAValid = dnaInputValidation.validateDNAinput();
			if (isDNAValid) {
				System.out.printf("DNA Sequence %d is Valid \n", dnaStrandIndex);
			}
			else {
				System.out.printf("DNA Sequence %d is Not Valid. Please check that the inputed sequence is DNA. \n", dnaStrandIndex);
				dnaStrandError = true;
			}
			dnaStrandIndex++;
		}
		
		System.out.println("\n");
		
		//compute dna statistics
		
		System.out.println("Compute DNA Sequence Length Nucleotide Composition");
		
		dnaStrandIndex = 1;
		
		if (!dnaStrandError) {
			for (String dnaSequence : dnaSequencesArray) {
				
				DNAstrand dnaStatistics;
				dnaStatistics = new DNAstrand(dnaSequence);
//				dnaStatistics.calculateDNAstats();
				
				System.out.printf("DNA Sequence %d Length: %d \n", dnaStrandIndex, dnaStatistics.lengthDNA);

				double percentageA = dnaStatistics.percentageA;
				double percentageT = dnaStatistics.percentageT;
				double percentageC = dnaStatistics.percentageC;
				double percentageG = dnaStatistics.percentageG;
				
				System.out.printf("DNA Sequence %d Nucleotide Composition: A: %f | T: %f | C: %f | G: %f  \n", dnaStrandIndex, percentageA, percentageT, percentageC, percentageG);
				
				dnaStrandIndex++;
			}						
		}
		else {
			throw new Exception("There is an error in the provided DNA sequences. Please review the input files prior to conducting transcription.");
		}
		
		System.out.println("\n");
		
		//transcription
		
		ArrayList<String> mRNASequencesArray = new ArrayList<>();
		
		dnaStrandIndex = 1;
		
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

		System.out.println("\n");

		//transcription output validation
		
		dnaStrandIndex = 1;
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
		
		System.out.println("\n");

		//translation
		
		if (!transcriptionOutputError) {
			dnaStrandIndex = 1;
			
			System.out.println("Conduct Translation from mRNA to Amino Acid Chain");
			
			translation conductTranslation;
			conductTranslation = new translation();
			
			ArrayList<String> aminoAcidSequencesArray = conductTranslation.translater(mRNASequencesArray);
			
			for (String peptideChain : aminoAcidSequencesArray) {
				System.out.printf("Peptide Chain Sequence %d: %s \n", dnaStrandIndex, peptideChain);
			}
		}
		
		else {
			throw new Exception("There is an error in the outputed mRNA Sequences. Please review the mRNA strands prior to conducting translation.");
		}


	}
	
	

}
