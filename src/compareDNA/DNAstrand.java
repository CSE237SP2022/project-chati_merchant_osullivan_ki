package compareDNA;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DNAstrand {
			
//	String DNAsequence;
	
	public void runDNAstrand(ArrayList<String> dnaSequencesArray) throws Exception {
//		DNAsequence = sequence;
						
		//validate dna input read through command line
		boolean isDNAValid = this.validateDNAinput(dnaSequencesArray);
		
		//if the dna strands are valid, compute dna statistics
		if(isDNAValid) {
			List<List<Double>> dnaStatisticsArray = this.calculateDNAstats(dnaSequencesArray);
		} else {
			throw new Exception("There is an error in the provided DNA sequences. Please review the input files prior to computing statistics.");
		}
		
		
	}
	
	public ArrayList<Integer> computeDNALengths(ArrayList<String> dnaSequencesArray) {
		
		ArrayList<Integer> dnaLengthsArray = new ArrayList<>();
		
		for (String dnaSequence : dnaSequencesArray) {
			int dnaLength = dnaSequence.length();
			dnaLengthsArray.add(dnaLength);
		}
		
		return dnaLengthsArray;
	}

	
	public boolean validateDNAinput(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
		
		int dnaStrandIndex = 0;
		boolean isDNAValid = true;
		ArrayList<Integer> dnaLengthsArray = this.computeDNALengths(dnaSequencesArray);
		
		System.out.println("Evaluate Inputed DNA Sequences");
		
		for (String dnaSequence : dnaSequencesArray) {
			
			int numValidNucleotides = 0;
			
			int lengthDNA = dnaLengthsArray.get(dnaStrandIndex);
			
			for(int i = 0; i < lengthDNA; i++) {
				if((dnaSequence.charAt(i) == 'A' || dnaSequence.charAt(i) == 'T' || dnaSequence.charAt(i) == 'C' || dnaSequence.charAt(i) == 'G')) {
					numValidNucleotides++;
				} else {
					System.out.printf("DNA Sequence %d is Not Valid. Please check that the inputed sequence is DNA. \n", dnaStrandIndex);
					isDNAValid = false;
					return isDNAValid;
				} 
			} 
			
			if (numValidNucleotides == lengthDNA) {
				System.out.printf("DNA Sequence %d is Valid \n", dnaStrandIndex);
			}
			
			dnaStrandIndex++;
		}
		
		
		return isDNAValid;
	}
	
	
	public List<List<Double>> calculateDNAstats(ArrayList<String> dnaSequencesArray) {
		
		int dnaStrandIndex = 0;
		List<List<Double>> dnaStatisticsArray = new ArrayList<>();
		ArrayList<Integer> dnaLengthsArray = this.computeDNALengths(dnaSequencesArray);
		
		System.out.println("Compute DNA Sequence Length Nucleotide Composition");
		
		for (String dnaSequence : dnaSequencesArray) {
		
			int lengthDNA = dnaLengthsArray.get(dnaStrandIndex);
			
			List<Double> dnaSequenceStatistics = new ArrayList<>();
			
			int percA = 0;
			int percC = 0;
			int percT = 0;
			int percG = 0;
			
			for(int dnaIndex = 0; dnaIndex < lengthDNA; dnaIndex++) {
				if(dnaSequence.charAt(dnaIndex) == 'A' ) {
					percA++;
				}
				if(dnaSequence.charAt(dnaIndex) == 'T' ) {
					percT++;
				}      
				if(dnaSequence.charAt(dnaIndex) == 'C' ) {
					percC++;
				}
				if(dnaSequence.charAt(dnaIndex) == 'G' ) {
					percG++;
				}
			}
			
			double percentageA = (double) percA/lengthDNA;
			double percentageT = (double) percT/lengthDNA;
			double percentageC = (double) percC/lengthDNA;
			double percentageG = (double) percG/lengthDNA;
			
			dnaSequenceStatistics.add(percentageA);
			dnaSequenceStatistics.add(percentageT);
			dnaSequenceStatistics.add(percentageC);
			dnaSequenceStatistics.add(percentageG);
			dnaStatisticsArray.add(dnaSequenceStatistics);
			
			System.out.printf("DNA Sequence %d Length: %d \n", dnaStrandIndex, lengthDNA);
			System.out.printf("DNA Sequence %d Nucleotide Composition: A: %f | T: %f | C: %f | G: %f  \n", dnaStrandIndex, percentageA, percentageT, percentageC, percentageG);
			
			dnaStrandIndex++;
		}
		
		return dnaStatisticsArray;

	}
	public String substringFrequency(String DNAsequence){
		

	}
	
}
