/* Enter your code here. Read input from STDIN. Print output to STDOUT 
The classname to be used is 'Solution'
*/

package codons;

import java.io.*;
import java.util.*;

class Solution{
 
	static HashMap<String,String> codon = new HashMap();	

	static public void getData()
	{	try{
			FileReader fileReader = new FileReader(new File("Codons.txt") );
			BufferedReader reader = new BufferedReader(fileReader);
			while(true)
			{
				String s= reader.readLine();
				codon.put(s.trim().split(" ")[0], s.trim().split(" ")[1]);
			}
		    }catch(Exception ex) { }
	}   

public static void main(String... s)
{        		String[] dnaArr = {"ACATGGTGCACCTGACTCTCATTTGAGATATAAAAAAACCATGAGAGCGATGGCGCTACGCATAATATAAAAA",
"ACATGGTGCACTTGACTCTCATTTGAGATATAAAAAAACCATCAGATCGATGGCGCTACGCATATTATAAATA",
"ACATGGTGCACCTGACGCTCATTTGCGATATAATAAATCCATGAGATCGATGGCGCTACGCATAATATAAAAA",
"ACATGGTGCACCTGACTCTCATTTGAGATATAAAAAAACCATGCGATCGCTGGCGCTACGCATAATATAAAGA",
"TCATGGTGCACCTGACTCTCATTTGAGATATAAGAAAACCATGAGATCGATGGCGATACGCGTAATATAAAAA",
"ACATGGTGCACCTGACTCTCATTAGAGATATAAAAAAACGATGAGTTCCATGGCGCTTCGCATAATATACAAA",
"ACATGGTGCACCAAACACTCATTTGAGATATAACAACACCATGGGATCGACGGCGCTACGCATAATATAAAAA",
"ACATGGTTCACCTGACTCTCATTTGCGATATAAAATAACCATGAGATCGATGGCGCTACGCATAATATAAAAA",
"TCGTGGTGCACCTGACTCTCATTTGAGATATATAAAATCCATGAGATGGATGGCGCTCCGCATAATATAAAAA",
"ACATGGTGCACCTGACTCTCATTTGAGACATAAAAAAACCATGAGATCGAAGGCCCTACGCATAATATAAAAA"};

for(String dna : dnaArr )
{	int pos=0;
	getData();
	//System.out.println("\nGot a new Dna ");
	while(pos<dna.length())
        	{	pos= dna.indexOf("ATG",pos-1);
		if(pos==-1)		break;
		
		String str = dna.substring(pos,pos+3);
            		while(( (str.compareTo( "TAA")==0) || (str.compareTo( "TAG")==0) || (str.compareTo( "TGA")==0) )==false)
		{	System.out.print(codon.get(str) );
			pos+=3;
			if(pos>=dna.length() )		break;
			str = dna.substring(pos,pos+3);
                	}
	        	System.out.println("");
	}
}
}

}          