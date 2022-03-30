package compareDNA;

public class DNAstrand {
	int percA = 0;
	int percC = 0;
	int percT = 0;
	int percG = 0;
	
	int lengthDNA = 0;
	
	String DNAsequence;
	
	public boolean validateDNAinput() {
		boolean checker = false;
		for(int i = 0; i < lengthDNA; i++) {
			if((DNAsequence.charAt(i) == 'A' || DNAsequence.charAt(i) == 'T' || DNAsequence.charAt(i) == 'C' || DNAsequence.charAt(i) == 'G')) {
				checker = true;
			}else {
				checker = false;
			}
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
		percA = percA/lengthDNA;
		percC = percC/lengthDNA;
		percT = percT/lengthDNA;
		percG = percG/lengthDNA;

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
