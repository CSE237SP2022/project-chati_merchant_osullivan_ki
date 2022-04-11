package compareDNA;

public class DNAstrand {
	int percA = 0;
	int percC = 0;
	int percT = 0;
	int percG = 0;
	
	double percentageA = 0;
	double percentageT = 0;
	double percentageC = 0;
	double percentageG = 0;
	
	int lengthDNA = 0;
	
	String DNAsequence;
	
	public boolean validateDNAinput() {
		boolean checker = false;
		int numValidNucleotides = 0;
		int numInValidNucleotides = 0;
		for(int i = 0; i < lengthDNA; i++) {
			if((DNAsequence.charAt(i) == 'A' || DNAsequence.charAt(i) == 'T' || DNAsequence.charAt(i) == 'C' || DNAsequence.charAt(i) == 'G')) {
				numValidNucleotides++;
			}else {
				numInValidNucleotides++;
			} 
		} 
		if (numValidNucleotides == lengthDNA) {
			checker = true;
			return checker;
		}
		return checker;
	}
	
	public DNAstrand(String sequence) {
		DNAsequence = sequence;
		DNAsequence.toUpperCase();
		lengthDNA = sequence.length();
		if(this.validateDNAinput()) {
			this.calculateDNAstats();
		}
	}
	
	public void calculateDNAstats() {
		for(int j = 0; j < lengthDNA; j++) {
			if(DNAsequence.charAt(j) == 'A' ) {
				percA++;
			}
			if(DNAsequence.charAt(j) == 'T' ) {
				percT++;
			}      
			if(DNAsequence.charAt(j) == 'C' ) {
				percC++;
			}
			if(DNAsequence.charAt(j) == 'G' ) {
				percG++;
			}
		}
		percentageA = (double) percA/lengthDNA;
		percentageT = (double) percT/lengthDNA;
		percentageC = (double) percC/lengthDNA;
		percentageG = (double) percG/lengthDNA;

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
