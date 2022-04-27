package compareDNA;

public class startStopCodons {
    // this method takes in the mRNA sequence as a string and parses through the
    // string to find the start codon
    // this method returns the mRNA sequence from the start codon onwards as string.
    public String findStart(String x) {
        for (int i = 0; i < x.length() - 2; i++) { // checking until the third to last character
            if (x.charAt(i) == 'A') {
                if (x.charAt(i + 1) == 'U') {
                    if (x.charAt(i + 2) == 'G') {
                        x = x.substring(i, x.length());
                    }
                }
            }
        }
        return x;
    }

    public String shortenedSequence(String x) {
        x = findStart(x);
        for (int i = 0; i < x.length() - 2; i=i+3) {//Goes through every 3 characters  
            if (x.charAt(i) == 'U') { //Checks through the characters
                if (x.charAt(i + 1) == 'A') {
                    if (x.charAt(i + 2) == 'A' || x.charAt(i + 2) == 'G') {
                        x = x.substring(0, i + 2);
                    }
                }
                if (x.charAt(i + 1) == 'G') {
                    if (x.charAt(i + 2) == 'A') {
                        x = x.substring(0, i + 2);
                    }
                }
            }
        }

        return x;
    };
}
