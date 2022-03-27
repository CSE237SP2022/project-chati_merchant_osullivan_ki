package compareDNA;
import java.io.*; //read file inputs and generate outputs
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class runCompareDNA {

	public static void main(String[] args) throws IOException { //IOException added
		
//		File dnaSequences = new File("src\\testFiles\\sameRandomDNASequences.txt");
		
//		Set<String> dnaSequences = new HashSet<>(Files.readAllLines(Paths.get("src/testFiles/sameRandomDNASequences.txt")));
		File currentDir = new File(".");
		File parentDir = currentDir.getParentFile();
		File dnaSequences = new File(parentDir,"testFiles/sameRandomDNASequences.txt");
		 
		if(dnaSequences.canRead())
		{
		    System.out.println(dnaSequences);
		}
//		Set<String> dictionary = new HashSet<>(Files.readAllLines(Paths.get(dnaSequences)));
		
//		BufferedReader br = new BufferedReader(new FileReader(dnaSequences));
//		
//		 String st;
//	     while ((st = br.readLine()) != null)
//	    	 System.out.println(st);

	}

}
