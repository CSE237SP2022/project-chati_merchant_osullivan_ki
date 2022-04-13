package compareDNA;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class transcription {
	
	public ArrayList<String> conductTranscription(ArrayList<String> dnaSequencesArray) {	
		
		int dnaStrandIndex = 0;

		ArrayList<String> mRNASequencesArray = new ArrayList<>();
		
		System.out.println("Conduct Transcription to mRNA");
				
		for (String dnaSequence : dnaSequencesArray) {
			
			String mRNAsequence = "";
			
			int lengthDNA = dnaSequence.length();
			
			for(int dnaIndex = 0; dnaIndex < lengthDNA; dnaIndex++) {
				if(dnaSequence.charAt(dnaIndex) == 'A' ) {
					mRNAsequence += 'U';
				}
				else if(dnaSequence.charAt(dnaIndex) == 'T' ) {
					mRNAsequence += 'A';
				}
				else if(dnaSequence.charAt(dnaIndex) == 'C' ) {
					mRNAsequence += 'G';
				}
				else if(dnaSequence.charAt(dnaIndex) == 'G' ) {
					mRNAsequence += 'C';
				}
			}
			
			mRNASequencesArray.add(mRNAsequence);
			
			System.out.printf("DNA Sequence %d: %s \n", dnaStrandIndex, dnaSequence);
			System.out.printf("RNA Sequence %d: %s \n", dnaStrandIndex, mRNAsequence);

			dnaStrandIndex++;
		}
		
		return mRNASequencesArray;
	}
}
