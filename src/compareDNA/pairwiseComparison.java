package compareDNA;

import java.util.ArrayList;

public class pairwiseComparison {
	
	public double similarityChecker(ArrayList<String> aminoAcidSequencesArray){
		
        System.out.print("Amino Acid Similarity Score");

		
		String aminoAcids1 = aminoAcidSequencesArray.get(0);
		String aminoAcids2 = aminoAcidSequencesArray.get(1);
        double totalAcids =0;
        double totalSimilarAcids =0;
        int aminoAcids2Length=aminoAcids2.length();
        int aminoAcids1Length=aminoAcids1.length();
        int smallerSequence = Math.min(aminoAcids1Length,aminoAcids2Length);
        int largerSequence = Math.max(aminoAcids1Length,aminoAcids2Length);
        for(int iteratorA=0; iteratorA<smallerSequence; iteratorA++){
            totalAcids=totalAcids+1;
            if(aminoAcids1.charAt(iteratorA)==aminoAcids2.charAt(iteratorA)){
                totalSimilarAcids=totalSimilarAcids+1;
            }
        }
        double similarityScore = totalSimilarAcids/(totalAcids+(largerSequence-smallerSequence));
        System.out.printf("Your Similarity Percentage is %f", similarityScore);
        return similarityScore;
    }
	
}
