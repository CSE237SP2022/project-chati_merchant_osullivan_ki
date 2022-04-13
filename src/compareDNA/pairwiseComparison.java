package compareDNA;

public class pairwiseComparison {
	
	public double similarityChecker(String[] aminoAcids1, String[] aminoAcids2){
        double totalAcids =0;
        double totalSimilarAcids =0;
        int aminoAcids2Length=aminoAcids2.length;
        int aminoAcids1Length=aminoAcids1.length;
        int smallerSequence = Math.min(aminoAcids1Length,aminoAcids2Length);
        int largerSequence = Math.max(aminoAcids1Length,aminoAcids2Length);
        for(int iteratorA=0; iteratorA<smallerSequence; iteratorA++){
            totalAcids=totalAcids+1;
            if(aminoAcids1[iteratorA]==aminoAcids2[iteratorA]){
                totalSimilarAcids=totalSimilarAcids+1;
            }
        }
        return totalSimilarAcids/(totalAcids+(largerSequence-smallerSequence));
    }
	
}
