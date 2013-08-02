import java.io.*;
import java.util.*;

class Suffix{
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		String[] list = new String[str.length+1];
		list[str.length] = "";
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=str.length-1; i>=0; i--){
			list[i] = str[i] + list[i+1];
			map.put(list[i],i);
		}
		Arrays.sort(list);
		for(int i=1; i<list.length; i++)
			System.out.println(map.get(list[i]));
	}
}