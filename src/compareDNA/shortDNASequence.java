package compareDNA;


public class shortDNASequence{

    public static int locationDNA(String DNASequence, String subString){
        int location = DNASequence.indexOf(subString);
        return location;
    }
}