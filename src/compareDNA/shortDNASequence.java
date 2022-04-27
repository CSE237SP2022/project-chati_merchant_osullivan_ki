package compareDNA;


public class shortDNASequence{
   //This method will return an int that is an index to where the subString is located in the DNASequence
    public static int locationDNA(String DNASequence, String subString){
        int location = DNASequence.indexOf(subString); //Finds the index at which the subString is located
        return location;
    }
}