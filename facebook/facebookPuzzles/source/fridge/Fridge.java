package fridge;

import java.io.*;
import java.util.*;
class Fridge{
	
	static int maxEngineers;
	static int maxDrinks;

	static ArrayList<Drinks> drinksList = new ArrayList<Drinks>();
	static ArrayList<Engineers> engineersList = new ArrayList<Engineers>();

	public void getValues(String fileName){
		try{	FileReader fileReader = new FileReader(new File(fileName) );
			BufferedReader reader = new BufferedReader(fileReader);
			
			String[] tokens = reader.readLine().trim().split(" ");
			maxEngineers = Integer.parseInt(tokens[0]);
			maxDrinks = Integer.parseInt(tokens[tokens.length-1]);

			for(int i=0; i< maxDrinks; i++)
			{	String[] line = reader.readLine().trim().split("\t");
				//System.out.println("Drink Code: "+line[0]+"\t name: "+line[line.length-1]);
				Drinks dk =new Drinks();
				dk.no = Integer.parseInt(line[0]);
				dk.drinkName = line[line.length-1];
				drinksList.add(dk);
				//System.out.println("Drink no: "+dk.no+"\t Drink Name : "+dk.drinkName);
				
			}
			for(int i=0; i< maxEngineers; i++)
			{	String[] line = reader.readLine().trim().split("\t");
				//System.out.println("Engineer: "+line[0]+"\t Drinks: "+line[line.length-1]);
				Engineers eg = new Engineers();
				eg.id = Integer.parseInt(line[0]);
				eg.drinks = line[line.length-1].split(",");
				engineersList.add(eg);
				//System.out.println("id : "+eg.id+"\t Drinks : "+eg.drinks);
			}					
			reader.close();
		}catch(Exception ex){	ex.printStackTrace();
		}
	}



	public static void setPreferences()
	{	for(int i=0; i< maxEngineers/2; i++)
		{	int score=0;
			Engineers e1 = engineersList.get(i);
			Engineers removal= null;
			//System.out.println("\nSize = "+engineersList.size());
			
			for(int j=maxEngineers/2; j< engineersList.size(); j++)
			{	//System.out.println("\nChecking for engineer : "+j);

				Engineers e2 = engineersList.get(j);
				int score1=0;
				for(int k= 0; k< maxDrinks; k++)
				{	//System.out.print("\nChecking for position : "+e1.drinks[k]+" with ");
					for(int l=0; l<maxDrinks; l++)
					{	//System.out.print(e2.drinks[l]);
						if( Integer.parseInt(e2.drinks[l])==Integer.parseInt(e1.drinks[k]) )
						{	if(l==k)		score1+= (maxDrinks-k)*(maxDrinks-k);
							else if(l>k)		score1+= (maxDrinks-k);
							//System.out.println("\nscore1 = "+score1);
						}
					}
				}
				if( score1 > score)
				{	score = score1;
					removal = e2;
					//System.out.println("\nScore = "+score+" score1 = "+score1+" removal = "+removal);
				}
			}
			//System.out.println("\nFinal Score = "+score+" Final removal = "+removal);
			e1.setPreference(removal.id);
			removeObj(removal);
				
		}
		//	System.out.println("\nFor engineer "+e1.id+" preference = "+id);
			
	}
	
	public static void removeObj( Engineers r)
	{	ArrayList<Engineers> newList = new ArrayList<Engineers>();
		for(Engineers e : engineersList)
		{	if(e.id!=r.id)
			newList.add(e);
		}
		engineersList= newList;
	}

	public static void main(String... s)
	{	Fridge f = new Fridge();
		f.getValues(s[0]);	
/*		System.out.println("\nEngineers: "+maxEngineers+"\tDrinks: "+maxDrinks);
		for( Engineers e : engineersList)
		{	System.out.print("id : "+e.id+"\t Drinks : ");
			for(int j=0; j< e.drinks.length; j++)
				System.out.print(" "+ e.drinks[j] );
			System.out.println("");
		}
			
*/		setPreferences();
		
		for(int i=0; i< maxEngineers/2; i++)
			System.out.println(engineersList.get(i).id +" "+ engineersList.get(i).preference ); 
	}
	
public class Drinks{
	int no;
	String drinkName;
}	

public class Engineers{
	int id;
	String[] drinks;
	int preference=0;

	public String valueAtIndex(int x)
	{	return drinks[x];
	}

	public int indexOf(String d)
	{	for(int i=0; i< drinks.length; i++)
		{	if(drinks[i] == d)
			return i;
		}
	return maxDrinks+1;
	}	

	public void setPreference(int id)
	{	preference = id;
	}
}

	
}