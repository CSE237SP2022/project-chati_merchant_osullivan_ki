package compareDNA;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DNAstrand {
	int percA = 0;
	int percC = 0;
	int percT = 0;
	int percG = 0;
	
	double percentageA = 0;
	double percentageT = 0;
	double percentageC = 0;
	double percentageG = 0;
	
	ArrayList<Integer> dnaLengthsArray;
		
//	String DNAsequence;
	
	public DNAstrand(ArrayList<String> dnaSequencesArray) throws Exception {
//		DNAsequence = sequence;
				
		//compute lengths of dna sequences
		this.computeDNALengths(dnaSequencesArray);
		
		//validate dna input read through command line
		boolean isDNAValid = this.validateDNAinput(dnaSequencesArray);
		
		//if the dna strands are valid, compute dna statistics
		if(isDNAValid) {
			this.calculateDNAstats(dnaSequencesArray);
		} else {
			throw new Exception("There is an error in the provided DNA sequences. Please review the input files prior to computing statistics.");
		}
		
		
	}
	
	public void computeDNALengths(ArrayList<String> dnaSequencesArray) {
		
		dnaLengthsArray = new ArrayList<>();
		
		for (String dnaSequence : dnaSequencesArray) {
			int dnaLength = dnaSequence.length();
			dnaLengthsArray.add(dnaLength);
		}
		
	}

	
	public boolean validateDNAinput(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
		
		
		int dnaStrandIndex = 0;
		boolean isDNAValid = true;
		
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
				} 
			} 
			
			if (numValidNucleotides == lengthDNA) {
				System.out.printf("DNA Sequence %d is Valid \n", dnaStrandIndex);
			}
			
			dnaStrandIndex++;
		}
		
		
		return isDNAValid;
	}
	
	
	public void calculateDNAstats(ArrayList<String> dnaSequencesArray) {
		
		int dnaStrandIndex = 0;
		
		System.out.println("Compute DNA Sequence Length Nucleotide Composition");
		
		for (String dnaSequence : dnaSequencesArray) {
		
			int lengthDNA = dnaLengthsArray.get(dnaStrandIndex);
			
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
			
			percentageA = (double) percA/lengthDNA;
			percentageT = (double) percT/lengthDNA;
			percentageC = (double) percC/lengthDNA;
			percentageG = (double) percG/lengthDNA;
			
			System.out.printf("DNA Sequence %d Length: %d \n", dnaStrandIndex, lengthDNA);
			System.out.printf("DNA Sequence %d Nucleotide Composition: A: %f | T: %f | C: %f | G: %f  \n", dnaStrandIndex, percentageA, percentageT, percentageC, percentageG);
			
			dnaStrandIndex++;
		}
		

	}
	
	public String DNAtomRNA() {
		String mRNAsequence = "";
		for(int j = 0; j < lengthDNA; j++) {
			if(DNAsequence.charAt(j) == 'A' ) {
				mRNAsequence += 'U';
			}
			else if(DNAsequence.charAt(j) == 'T' ) {
				mRNAsequence += 'A';
			}
			else if(DNAsequence.charAt(j) == 'C' ) {
				mRNAsequence += 'G';
			}
			else if(DNAsequence.charAt(j) == 'G' ) {
				mRNAsequence += 'C';
			}
		}
		
		return mRNAsequence;
	}
}
