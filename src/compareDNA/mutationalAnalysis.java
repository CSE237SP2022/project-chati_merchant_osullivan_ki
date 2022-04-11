package compareDNA;

import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class mutationalAnalysis {

    public List<Map.Entry<Integer, ArrayList<Character>>> detectSubstitution(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
    	
    	String refDNASequence = dnaSequencesArray.get(0);
    	String mutDNASequence = dnaSequencesArray.get(1);
    	
        List<Map.Entry<Integer, ArrayList<Character>>> mutationsArray = new ArrayList<>();
    	
    	for (int seqIndex = 0; seqIndex < refDNASequence.length(); seqIndex++) {
    		char refNucleotide = refDNASequence.charAt(seqIndex);
    		char mutNucleotide = mutDNASequence.charAt(seqIndex);
    		
    		if (Character.compare(refNucleotide, mutNucleotide) != 0) {
    			ArrayList<Character> substitutionArray = new ArrayList<>();
    			substitutionArray.add(refNucleotide);
    			substitutionArray.add(mutNucleotide);
    			Map.Entry<Integer, ArrayList<Character>> mutationPosition = new AbstractMap.SimpleEntry<>(seqIndex, substitutionArray);
    			mutationsArray.add(mutationPosition);
    		}
    	}
    	
    	return mutationsArray;
    	
    }

}
