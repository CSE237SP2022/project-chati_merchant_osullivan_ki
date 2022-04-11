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
    			Map.Entry<Integer, ArrayList<Character>> mutationPositions = new AbstractMap.SimpleEntry<>(seqIndex, substitutionArray);
    			mutationsArray.add(mutationPositions);
    		}
    	}
    	
    	return mutationsArray;
    	
    }
    
    public List<Map.Entry<Integer, ArrayList<Character>>> detectionPointInsertion(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
    	
    	String refDNASequence = dnaSequencesArray.get(0);
    	String mutDNASequence = dnaSequencesArray.get(1);
    	
        List<Map.Entry<Integer, ArrayList<Character>>> mutationsArray = new ArrayList<>();
    	
        if (mutDNASequence.length() > refDNASequence.length()) {
        	for (int seqIndex = 0; seqIndex < refDNASequence.length(); seqIndex++) {
        		char refNucleotide = refDNASequence.charAt(seqIndex);
        		char mutNucleotide = mutDNASequence.charAt(seqIndex);
        		
        		if (Character.compare(refNucleotide, mutNucleotide) != 0) {
        			int nextSeqIndex = seqIndex + 1;
        			char nextMutNucleotide = mutDNASequence.charAt(nextSeqIndex);
        			if (Character.compare(refNucleotide, nextMutNucleotide) == 0) {
        				ArrayList<Character> insertedNucleotides = new ArrayList<>();
        				insertedNucleotides.add(refNucleotide);
            			insertedNucleotides.add(mutNucleotide);
            			Map.Entry<Integer, ArrayList<Character>> mutationPositions = new AbstractMap.SimpleEntry<>(seqIndex, insertedNucleotides);
            			mutationsArray.add(mutationPositions);
        			}
        			
        		}
        	}
        }
        
    	return mutationsArray;
    	
    }
    
    public List<Map.Entry<Integer, Character>> detectionPointDeletion(ArrayList<String> dnaSequencesArray) throws FileNotFoundException {
    	
    	String refDNASequence = dnaSequencesArray.get(0);
    	String mutDNASequence = dnaSequencesArray.get(1);
    	
        List<Map.Entry<Integer, Character>> mutationsArray = new ArrayList<>();
    	
        if (mutDNASequence.length() < refDNASequence.length()) {
        	for (int seqIndex = 0; seqIndex < refDNASequence.length(); seqIndex++) {
        		char refNucleotide = refDNASequence.charAt(seqIndex);
        		char mutNucleotide = mutDNASequence.charAt(seqIndex);
        		
        		if (Character.compare(refNucleotide, mutNucleotide) != 0) {
        			int nextSeqIndex = seqIndex + 1;
        			char nextRefNucleotide = refDNASequence.charAt(nextSeqIndex);
        			
        			if (Character.compare(nextRefNucleotide, mutNucleotide) == 0) {
        				Character deletedNucleotide = refNucleotide;
            			Map.Entry<Integer, Character> mutationPositions = new AbstractMap.SimpleEntry<>(seqIndex, deletedNucleotide);
            			mutationsArray.add(mutationPositions);
        			}        			
        			
        		}
        	}
        }
        
    	return mutationsArray;
    	
    }

 

}
