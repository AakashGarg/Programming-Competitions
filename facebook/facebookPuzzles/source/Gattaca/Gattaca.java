import java.io.*;
import java.util.HashSet;

class Gattaca{
	static String dna="";
	static int score = 0;
	private HashSet<String> subDnaArr = new HashSet<String>();
	public void getData()
	{	try{
			FileReader fileReader = new FileReader(new File("GattacaValues.txt") );
			BufferedReader reader = new BufferedReader(fileReader);
			int n = Integer.parseInt( reader.readLine() );
			for(;n>0; n-=80 )
				dna+= reader.readLine();
						
			n = Integer.parseInt(reader.readLine());
			
			while(n>0)
			{	check( removeUselessSpaces(reader.readLine()).trim().split(" ") );
				
				n--;
			}
		}catch(Exception ex) {ex.printStackTrace();
		}
	}		

	private String removeUselessSpaces( String line)
	{	char[] tok =line.toCharArray();
		char[] newTok = new char[(line.replaceAll(" ","").length())+3];
		for(int i=0,k=0; i< line.length(); i++)
		{	if( !((tok[i]== ' ')&& (tok[i+1]==' ') ) )	newTok[k++]=tok[i];
		}
		return(String.valueOf(newTok));
	}

	private void check(String[] tokens )
	{	String subDna = dna.substring(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]) );
		System.out.println(subDna);
		boolean flag = false;
		if(subDnaArr.size() ==0)	subDnaArr.add(subDna);
		else if(subDnaArr.size() >0)
		{	for(String str : subDnaArr)
			{	int length = (str.length() - subDna.length());
				if(length > 0) 
				{	for(int i=0; i< length; i++)
					{	if(str.substring(i,i+subDna.length()) == subDna)	
						{	System.out.println("Match found");
							flag = true;
							break;
						}
					}
				}
			}	
			if(flag == false)	
			{	subDnaArr.add(subDna);
				score += Integer.parseInt(tokens[2]);
			}
		
		}
	}				
	
	public static void main(String... s)
	{	Gattaca g = new Gattaca();
		g.getData();
		System.out.println(score);
	}
} 