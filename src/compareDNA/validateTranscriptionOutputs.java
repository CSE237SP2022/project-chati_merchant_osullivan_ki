package compareDNA;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class validateTranscriptionOutputs {
	
    public boolean validator(ArrayList<String> mRNASequencesArray) {
    	
    	System.out.println("Validate Transcription Outputs");
    	
    	int dnaStrandIndex = 0;
    	
    	boolean isRNAValid = true;
    	
    	for (String mRNASequence : mRNASequencesArray) {      
       
            if (mRNASequence.contains("T")) { //Checks if the "mRNA has a t or not." Not mRNA if there is a T
            	System.out.printf("mRNA Sequence %d is Not Valid. It contains the nucleotide T. \n", dnaStrandIndex);
            	isRNAValid = false;
            	return isRNAValid;
            } else {
            	System.out.printf("mRNA Sequence %d is Valid \n", dnaStrandIndex);
            }
            
            dnaStrandIndex++;
    	}
    	
    	return isRNAValid;
    	
    }
}
