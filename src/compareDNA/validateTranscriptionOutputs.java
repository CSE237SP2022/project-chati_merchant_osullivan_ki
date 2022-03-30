package compareDNA;

public class validateTranscriptionOutputs {

    public boolean validator(String x) {
        int success = 0;
        boolean isRNA = true;
        String [] sentence = new String [x.length()];
        for(int i = 0; i < x.length(); i++){
            sentence[i] = String.valueOf(x.charAt(i));
        }
        if (x.contains("T")) { //Checks if the "mRNA has a t or not." Not mRNA if there is a T
        	isRNA = false;
        	return isRNA;
        }
        
        if (x.contains("U")) { //if there is a U, then it's not DNA. So return not dna or rna
            return isRNA;
        } 

        System.out.println(sentence);
        return isRNA; //return a success if there is no t or u in the mRNA passed into this.
    }
}
