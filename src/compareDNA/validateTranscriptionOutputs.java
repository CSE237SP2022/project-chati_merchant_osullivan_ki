package compareDNA;

public class validateTranscriptionOutputs {

    public int validator(String x) {
        int success = 0;
        int isDNA = 1;
        int notDNARNA = 2;

        if (x.contains("t")) { //Checks if the "mRNA has a t or not." Not mRNA if there is a T
            if (x.contains("u")) { //if there is a U, then it's not DNA. So return not dna or rna
                return notDNARNA;
            } else { //if there is no U but has a T, then it is still DNA
                return isDNA;
            }

        }
        return success; //return a success if there is no t or u in the mRNA passed into this.
    }
}
