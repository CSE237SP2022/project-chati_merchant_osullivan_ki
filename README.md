# The DNA Compare-Inator

The program takes a set of DNA strands - a sequence of nucleotide base pairs represented by A,T,C, and G - and first converts them to mRNA sequences via the process of transcription. Next, the mRNA sequences are converted to amino acids via the process of transcription. This involves splitting the mRNA sequences into subsets of 3 nucleotide base pairs (codons), which map to amino acid residues that form peptide chains. Finally, the two output peptide chains are compared based on the degree of overlapping amino acid residues. 

Directions to run the program are provided at the bottom along with a list of commands. 

And yes, this program was named after the world famous scientist and inventor [Dr. Heinz Doofenshmirtz](https://en.wikipedia.org/wiki/Dr._Heinz_Doofenshmirtz). His other ingenous -inators can be found [here](https://phineasandferb.fandom.com/wiki/List_of_Doofenshmirtz%27s_schemes_and_inventions)

##### Project Github Names
###### project-chati_merchant_osullivan_ki
###### project-chati_merchant_osullivan_ki created by GitHub Classroom

# Iteration 1 | 03/30/2022

## Stories Completed

### Command Line Initiation
- The program can be initiated from the command line with the set of commands provided at the bottom of this document

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
- For now, the amino acid at each index for the two peptide chains is compared and the overall similarity is reported
- The percentage similarity will account for insertions and deletions in future iterations

### Unit Tests for Validating Functionality
- Unit tests were deeveloped to test reading in DNA sequences, testing the functionality of transcription and translation, and evaluating outputs
- Further unit tests to test more robust performance will be developed during the second iteration

## Stories to Complete for Iteration 2

### Expand Scope of DNA Analysis 
- During iteration 2, we are hoping to improve the realm of statistics computed on the DNA sequences
- This includes comparing it to a database of sequences and identifying similar substrings, identifying any repeating patterns of nucleotides, and identifying segments of repeated nucleotides (possibly indicating regulatory elements)

### Parse DNA Sequences with Lengths Not Divisible by 3
- The program should take in DNA sequences that are not of lengths divisible by 3
- We are aiming to account for the overhang by either deleting it or implementing it in the insertion and deletion model for the amino acid pairwise comparison

### Start and Stop Translation at Appropriate Codons
- Certain codons initiate and terminate the process of translation
- We are aiming to parse through the DNA sequence and identify where the start and stop codons are and then only translate the segements in between

### Identify Sources of Insertions and Deletions Between DNA Sequences and Amino Acid Peptides
- This would involve using better models to compute the probability of an insertion or deletion (hidden markov models may be the most useful in this area)
- We would want to say that certain residues have either been added or deleted, and maybe tie that to downstream issues in folding

### Identify Simple Folding Patterns Based on Amino Acid Residues
- Since protein folding is one of the most complex problems in computing, we are aiming to simplify our folding pattern indicator to certain residues that indicate bridges or hallmark structures
- One such being cysteine residues forming a bridge if distributed far enough
- Similarly, we can detail properties of the protein based on the amino acid resides: more polar residues may indicate a channel, more neutral residues with certain highly reactive residues may indicate an enzyme, etc. 

### Expand Set of Test Files
- We are hoping to expand on the set of test files we use, including real genomic segments from NCBI GEO
- Using real genomic data may give us better grounds for testing the power and efficiency of our program

## Errors and Challenges

### File Not Found Error
- The first main error incurred involved the importation of text files corresponding to the amino acid dictionary and the DNA sequences
- Originally, we incurred a file not found error, however, we resolved this by providing a more direct path to the file to avoid an ambiguity 

### JUnit Module Export Error
- The JUnit tests would not true due to an error in the .classpath file and the module-info.java files
- We imported the necessary requirements into module-info.java and exported the test package to JUnit 
- We then changed the .classpath; this was done automiatically by the IDE

### DNA Sequence String Indexing Array while During Translation
- When finding subsets of length 3 in the DNA sequences, we realized that sometimes, if the lenght was not divisble by three, there would be overhang string subsets that were less than length 2
- Each codon needs to be specifically 3 nucleotide base pairs in order to be read, however, codons are read based on certain start and stop signals
- Since we did not account for this, we included a temporary fix by making the test DNA sequences have lengths divisible by 3
- A more robust correction would involve checking the overhang and ommitting if necessary

### Insertion and Deletions in Peptide Chains
- One challenge we are still working on is properly discovering insertions and deletions between two peptide chains
- Since insertions and deletions can cause difference in lengths of the chains and may cause index changes, more robust statistical models need to be used

# Iteration 2 | 04/13/2022

## Iteration 2 Overview

The second iteration primarily focused on revising errors found during the first iteration while improving the structure of the code, inclduing cleanliness and conciseness. We also updated the unit tests - they were made shorter and each unit test now corresponds with a method or functionality of our program. Along with improving the code structure, we also implemented added functionality to our program. These updates can be found below. In addition, the a set of commands can be found at the bottom of this document. 

## Stories Completed

### Program Script
- We have generated a script to call the program; the script is labeled __runCompareDNA.sh__ and is in the __src__ folder
- Instructions on how to use the script are in the __Run Commands__ section; we are aiming to expand the script and resolve withstanding errors for the final iteration

### Code Structure and Cleanliness
- As mentioned in the overview, this method was less about adding functionality and more about cleaning up the code structure; the final iteration will focus on maintaining the structure and cleanliness while significantly improving functionality
- To begin, we altered our runDNACompare.java class to remove unnecessary static declarations, condense classes, and improve general structure
- Next, we went through each class and modified the code such it prints the outputs properly and can be called independently during unit testing
- We also implemented a few other functional modules, however, they have yet to be integrated with the entire program
- Finally, we began working on a script to run the program, however, this has led to numerous unexpected errors; this will be detailed in the challenges section

### Unit Tests for Validating Functionality
- Unit tests were added for each method implemented in the runCompareDNA.java class
- Unit tests still need to be developed for added methods such as detecting point mutations; this will be done in the following iteration
- All unit tests pass for methods up to and including translation

### Detection of Point Mutations
- The program can now parse through two DNA sequences, the first one being a reference sequence and second one being a mutated sequence, and identify sources of point mutations
- Point mutations are changes in a single nucleotide base pair at one position; this includes insertions, deletions, and subsitutions
- The future iteration will focus on integrating all three of aforementioned mutation types to make a comprehensive mutation detection system
- We are still refining the functionality of the mutational detection module; it will be completely implemented in the following iteration

### Begin and Terminate Translation at Approrpiate Codons
- The program can now begin and terminate translation based on the appropriate start and stop codons; this is vital for being able to read DNA sequences that have lengths indivisible by three
- The class is complete and functional; we are working on integrating this function with our entire program for the following iteration

### Pairwise Comparison of Amino Acid Chains
- We implemented and completed a pairwise checking module that compares the outputted amino acid chains during the translation step
- The module checks overlap and documents the percentage similarity between two amino acid chains
- We are currently working on integrating this module into the entire program; then we aim to develop unit tests to test edge cases

## Stories to Complete for Iteration 3

### Improving Functionality
- The third iteration will revolve around functionality and running the program more efficiently
- This involves adding more complex analysis modules, being able to call or turn off certain analysis functions, and using an API to compare output results

### Generating a More Comprehensive Script 
- We have a preliminary script working; the details are listed below in the __Run Commands__ section, however, we are aiming to develop a more comprehensive script for the following iteration
- We want to finalize our script for the coming iteration; the script will be able to run the program while taking in a file as the input
- We also are experimenting with the idea of being able to call certain analysis functions based on the arguments provided to the scripts

### Complete Mutation Detection
- This module, we implemented a method to detect point mutations; the following iteration will integrate this method into the main program and adapt it such that it can detect mutations of any size to a reasonable degree
- We intend to employ more rigorous statistical models for this portion of the project

### Integrate Pairwise Comparator 
- We completed a pairwise amino acid analysis method this iteration; the next iteration will focus on integrating this module with the entire program
- We are also working on using the SwissProt API to compare outputs of program to real amino acid chains to detection potential patterns and folding regimes

### Complete Unit Testing
- The final iteration will have complete unit tests for all of the aforementioned methods we are aiming to integrate with our main program
- This also means generating more test files; this iteration we toggled the test files to help with unit testing, and the following iterations, we are going to add test files that resemble true DNA sequences

## Errors and Challenges

### Scripting Errors
- This iteration, we ran into way more errors than the last iteration primarily because we were more focused on code structure than actual functionality
- We are currently dealing with several errors when using a script to run the java program; we aim to have these issues resolved by the final iteration
- It seems the errors have something to do with not using the proper java versions, however, we need to dig deeper in order to better understand the problem

### Frameshift Challenge when Detecting Start Codon
- During the phase where we were detecting the start codons, we initially ran into a challenge with parsing the DNA sequence
- We resolved this by taking every single 3-mer of the DNA string, and identifying where the beginning of a start codon was; this is currently implemented in a brute-force manner, however, we expect that some dynamic programming methods may be employable here

#### Detecting Mutations
- We were able to detect mutations in the middle of sequences, however, we are still handing edge cases, such as detecting mutations at the beginning or end of a sequence
- This is particularly tough for insertions and deletions because you have to shift the frame or view of the DNA sequence temporarily in order to understand how deep the mutation is

# Iteration 3

## Stories Completed

### Overview
- This iteration largely focused on cleaning up the code while adding smaller functional pieces that were well tested and structured properly. 
- We first wrote unit tests for all of the methods that are being implemented; this means that every method that exists in the print statements when the program is called through the script has a unit test
- Next, we implemented a method to check whether certain substrings or smaller gene sequences exist in a larger sequence; this helps validate whether certain genes exist in a larger DNA sequence which could indicate functionality
- 

### Unit Testing

## Challenges & Errors


# Run Commands

### Overview

For this section, you must be in the __src__ folder. You can enter this folder from the main project folder by using __cd src__. Once done, you can either follow the directions to compile the code below or call the script based on the directions in the __Script__ section. Since we are still error handling the script, if there are any errors in the script, please follow the __Directions__ and __List of Commands__ sections below as an alternative.

### Directions
- Open a command prompt with the appropriate Java, Git, and OS versions
- Once you have cloned the repository, ensure you are on the main branch (default)
- Navigate into the src directory with the command: __cd src__; your command line should look something like: __...\project-chati_merchant_osullivan_ki\src>__
- From the src directory, if the program has not compilied, first run: __javac compareDNA/runCompareDNA.java__
- To then run the program once in src, call the program on a test file in the testFiles folder: __java compareDNA.runCompareDNA testFiles/{testFileName.txt}__

### List of Commands (Call in src Folder)
- Compile program prior to running: __javac compareDNA/runCompareDNA.java__
- Run the following to see the true meaning of life: __java compareDNA.runCompareDNA testFiles/surpriseDNASequences.txt__
- Compare same DNA sequences: __java compareDNA.runCompareDNA testFiles/sameRandomDNASequences.txt__
- Compare drastically different DNA sequences: __java compareDNA.runCompareDNA testFiles/differentRandomDNASequences.txt__
- Non-DNA sequences (throws DNA validation exception): __java compareDNA.runCompareDNA testFiles/notDNASequences.txt__

### Script
- Either you can run the commands above, or you can enter the __src__ via __cd src__ and call the __runCompareDNA.sh__ script with the appropriate filename
- For example, you can call __bash__ and then __runCompareDNA.sh testFiles/surpriseDNASequences.txt__
