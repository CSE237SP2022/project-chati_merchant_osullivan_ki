package compareDNA;

public class startStopCodons {
    //this method takes in the mRNA sequence as a string and parses through the string to find the start codon
    //this method returns the mRNA sequence from the start codon onwards as string.
    public static String findStart(String x){ 
        for(int i = 0; i < x.length()-2; i++){ //checking until the third to last character 
            if(x.charAt(i) == 'A'){
                if(x.charAt(i+1) == 'U'){
                    if(x.charAt(i+2) == 'G'){
                        x = x.substring(i, x.length());
                    }
                }
            }
        }  
        return x;
    }
    public static String startStop(String x){ //
        x = findStart(x);
        for(int i = 0; i < x.length(); i = i+3){

        }


       
    };
}
