package faceBull;
import java.util.*;
import java.io.*;

public class FaceBull{
	ArrayList<Machine> machineList = new ArrayList<Machine>();
	ArrayList<Machine> finalList;
	ArrayList<Machine> reqList;
	ArrayList<Machine> tempList;
	
	public void extractValues(String fileName)
	{	try{	FileReader fileReader = new FileReader(new File(fileName));
			BufferedReader reader = new BufferedReader(fileReader);
			String line= null;
			while( (line = reader.readLine() )!=null)
			{	String finalString = removeUselessSpaces( line);
				Machine mc = new Machine(finalString.split(" "));
				machineList.add(mc);
			}
		}catch(Exception e){	e.printStackTrace();
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

	private void removeDest( int destChem)
	{	for(int i=0; i< tempList.size(); i++)
		{	Machine m = tempList.get(i);
			if(m.destChem== destChem)
			{	tempList.remove(m);
				i--;
			}
		}
	}


	public void go()
	{	finalList = machineList;
		for(Machine m : machineList)
		{	reqList = new ArrayList<Machine>();
			tempList = ( ArrayList<Machine>) machineList.clone();
			doWork(m);
			if( netPrice(reqList) < netPrice(finalList) )		finalList = reqList;	
		}
	}
	
	private int netPrice(ArrayList<Machine> lst)
	{	int netPrice=0;
		for(Machine m : lst)
			netPrice+= m.price;	
		return netPrice;
	}
		 
	private void doWork( Machine m)
	{	reqList.add((Machine) m.clone());
		removeDest(m.destChem);
		Machine m1 = getNextMin(m);
		if(m1 != null)
		{	doWork(m1);
		}
	}

	private Machine getNextMin(Machine m)
	{	Machine comp = null;
		if(tempList.size() == 0)	return null;
		for( Machine m1 : tempList)
		{	if( (m1.sourceChem == m.destChem) && ( m1.destChem != m.sourceChem) )
			{	comp = m1;
				break;
			}
		}
		for(Machine m1 : tempList)
		{	if( (m1.sourceChem == m.destChem) && (m1.destChem!= m.sourceChem) && (m1.price < comp.price) )
				comp =  m1;
		}
		return comp;
	}

	public static void main(String... s)
	{	FaceBull fb= new FaceBull();
		fb.extractValues(s[0]);
		fb.go();
		Collections.sort(fb.finalList);
		System.out.println(fb.netPrice(fb.finalList));
		for( Machine m: fb.finalList)
			System.out.print(m.name+" ");
		System.out.println("\b");
	}
	

public class Machine implements Cloneable, Comparable<Machine>{
	int name;
	int sourceChem;
	int destChem;
	int price;

	Machine(String[] finalString)
	{	name 	= 	Integer.parseInt(finalString[0].substring(1));
		sourceChem = 	Integer.parseInt(finalString[1].substring(1));
		destChem = 	Integer.parseInt(finalString[2].substring(1));
		price	 = 	Integer.parseInt(finalString[3]);
	}

	Machine() {}
	public Object clone()
	{	Machine m= new Machine();
		m.name = name;
		m.sourceChem = sourceChem;
		m.destChem = destChem;
		m.price = price;
		return ( (Object) m );
	}

	public int compareTo(Machine m)
	{	return( Integer.valueOf(name).compareTo((Integer)m.name) );
	}
}

}
