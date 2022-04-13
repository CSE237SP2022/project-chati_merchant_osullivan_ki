package compareDNA;

import java.io.*; //read file inputs and generate outputs
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class translation {
	
//	private String aminoAcidDictionaryPath = "compareDNA/aminoAcidsDictionary.txt";
	
    public ArrayList<String> translater(ArrayList<String> dnaSequencesArray, Boolean isRNAValid, String aminoAcidDictionaryPath) throws Exception {
        
    	if (isRNAValid) {
    		
    		System.out.println("Conduct Translation from mRNA to Amino Acid Chain");	
    		
    		int dnaStrandIndex = 0;
    		
    		List<Map.Entry<String, String>> codonAminoAcidMap = new ArrayList<>();
            Scanner aminoAcidsDictionary = new Scanner(new File(aminoAcidDictionaryPath)); // CHANGE this to
                                                                                                         // run from src
            while (aminoAcidsDictionary.hasNextLine()) {
                String codonAminoAcidMapping = aminoAcidsDictionary.nextLine(); // store each next dna sequence in the array
                String[] codonToAminoAcidArray = codonAminoAcidMapping.split("\\s+");
                String codon = codonToAminoAcidArray[0];
                String aminoAcid = codonToAminoAcidArray[2];
                Map.Entry<String, String> codonToAminoAcidEntry = new AbstractMap.SimpleEntry<>(codon, aminoAcid);
                codonAminoAcidMap.add(codonToAminoAcidEntry);
            }

            ArrayList<String> aminoAcidSequencesStringArray = new ArrayList<String>();

            for (String dnaSequence : dnaSequencesArray) {
                List<String> dnaCodonsArray = new ArrayList<String>();
                for (int i = 0; i < dnaSequence.length(); i += 3) {
                    String newTestLine = dnaSequence.substring(i);
                    String codon = newTestLine.substring(0, 3);
                    dnaCodonsArray.add(codon);
                }

                ArrayList<String> aminoAcidSequencesCharArray = new ArrayList<String>();

                for (String codon : dnaCodonsArray) {
                    for (Map.Entry<String, String> codonEntry : codonAminoAcidMap) {
                        String mRNACodonEntry = codonEntry.getKey().replace('T', 'U');
                        if (mRNACodonEntry.equals(codon)) {
                            aminoAcidSequencesCharArray.add(codonEntry.getValue());
                        }
                    }
                }

                StringBuilder aminoAcidPeptideChainBuilder = new StringBuilder();

                for (String aminoAcid : aminoAcidSequencesCharArray) {
                    aminoAcidPeptideChainBuilder.append(aminoAcid);
                }

                String aminoAcidPeptideChain = aminoAcidPeptideChainBuilder.toString();
                aminoAcidSequencesStringArray.add(aminoAcidPeptideChain);
                
                System.out.printf("Peptide Chain Sequence %d: %s \n", dnaStrandIndex, aminoAcidPeptideChain);
                
                dnaStrandIndex++;

            }
            
            return aminoAcidSequencesStringArray;
            
    	} else {
			throw new Exception("There is an error in the outputed mRNA Sequences. Please review the mRNA strands prior to conducting translation.");
		}
        
    }
}