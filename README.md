# project-chati_merchant_osullivan_ki
### project-chati_merchant_osullivan_ki created by GitHub Classroom
This project takes a set of DNA strands - a sequence of nucleotide base pairs represented by A,T,C, and G - and identifies pairwise differences between 
the nucleotide bases from each DNA strand. We can compare deletions and insertions within the two DNA strands to identify points of difference and overall similarities.

# Iteration 1 | 03/30/2022

## Stories Completed

### Command Line Initiation

### Read Sample DNA Sequences from Text File
- The program is able to take in a text file that contains 2 DNA sequences; one for each line
- The text file is parsed and each line corresponding to a DNA sequences is added to a string array; thus each DNA sequences is represented as a string
- For the current iteration, the test files contain strings that have lengths divisible by 3; this makes converting to codons much simpler, however, we are aiming to make the program more malleable in the next iteration

### Validate DNA Input and Generate DNA Statistics
- Once the DNA sequences have been properly extracted from the text file, the two strands are analyzed
- First, the sequences are validated to make sure that they are indeed DNA sequences; for now, validation entails checking that each character or nucleotide base pair is either an A, T, C, or G
- If the validation passes for both strands, then basic statistics are computed for the DNA strands, includign percentage of each nucleotide base pair and length; we hope to expand to the scope of statistics computed for the DNA strands in the next iteration
- The DNA statistics are valuable for assessing the overall similarities between the two sequences; they essentially serve as a calibration or base metric for comparing two DNA sequences
- Once validation and analysis is complete, transcription is conducted

### DNA Transcription to mRNA and Validation
- DNA transcription to mRNA is a process that involves converting double-stranded DNA into a single-stranded mRNA sequence that is readable by other cellular machinary such as ribosomes
- Programmatically, this involves looking at the DNA sequence and mapping each nucleotide to its complementary nucleotide; G maps to C, C maps to G, T maps to A, and A maps to U
- Notice, even thought T maps to A, A does not map back to T; this is because in mRNA strands, T's are excluded and instead take the form of Uracil (U)
- Once the mRNA strands have been produced, they need to me validated; for now, validation entails checking to make sure that all of the nucleotide base paris are either A, U, C, or G
- Once the transcription outputs are validated, the mRNA strands are stored and then passed on to be translated

### Translation with Codon to Amino Acid Dictionary Text File
- Translation involves taking an mRNA sequence and mapping it to a set of amino acids base on consecutive nucleotide base pairs of length 3 called codons; different codons may map to the same amino acid
- This portion of the program reads in a text file and generates a dictionary that maps from the codons (subset of 3 nucleotide base pairs) to amino acids
- First, the mRNA string is split into subsets of strings with lengths 3; these represent the codons
- For now, all test files have strings that have lengths divisible by 3, however, this will be improved in the next iteration
- Next, each codon is mapped from its dictionary input to the amino acid output
- Once done, a compiled array of amino acids are joined into a peptide string; this represents a protein's primary structure, the linear sequence of amino acids
- Once the mRNA sequences have been translated, pairwise similarities can be analyzed

### Pairwise Amino Acid Comparison

### Unit Tests for Validating Functionality

## Stories to Complete for Iteration 2

### Expand Scope of DNA Analysis 

### Parse DNA Sequences with Lengths Not Divisible by 3

### Start and Stop Translation at Appropriate Codons

### Identify Sources of Insertions and Deletions Between DNA Sequences and Amino Acid Peptides

## Errors

### File Not Found Error

### JUnit Module Export Error

### DNA Sequence String Indexing Array while During Translation

## Run Commands
