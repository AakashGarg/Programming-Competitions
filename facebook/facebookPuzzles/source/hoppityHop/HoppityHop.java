package hoppityHop;
import java.io.*;

public class HoppityHop{
	private int no;

	public int getValue(String fileName)
	{	int value=0;	
		try{	File myFile = new File(fileName);
			FileReader fileReader = new FileReader(myFile);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line= null;
			while ((line=reader.readLine()) != null)
			{	value = Integer.parseInt(line);
			}
			reader.close();
		}catch(Exception ex){	ex.printStackTrace();
		}
	return value;
	}

	public static void main(String... s)
	{	HoppityHop obj = new HoppityHop();
		int value = obj.getValue(s[0]);
		for(int i=1; i<=value ; i++)
		{	if(i%15==0)	
				System.out.println("Hop");
			else if(i%5==0)
				System.out.println("Hophop");
			else if(i%3==0)
				System.out.println("Hoppity");
		}
	}
}