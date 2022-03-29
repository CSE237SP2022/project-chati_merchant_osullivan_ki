package compareDNA;

public class validateTranscriptionOutputs {

    public int validator(String x) {
        int success = 0;
        int isDNA = 1;
        int notDNARNA = 2;
        String [] sentence = new String [x.length()];
        for(int i = 0; i < x.length(); i++){
            sentence[i] = String.valueOf(x.charAt(i));
        }
        if (x.contains("T")) { //Checks if the "mRNA has a t or not." Not mRNA if there is a T
            if (x.contains("U")) { //if there is a U, then it's not DNA. So return not dna or rna
                return notDNARNA;
            } else { //if there is no U but has a T, then it is still DNA
                return isDNA;
            }

        }
        System.out.println(sentence);
        return success; //return a success if there is no t or u in the mRNA passed into this.
    }
}
