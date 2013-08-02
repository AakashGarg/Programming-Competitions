import java.io.*;

class WhatNext{
	private static String solve(int a, int b, int c){
		if(2*b == (a+c))		return "AP "+(c+(c-b));
		else 					return "GP "+(c*(c/b));
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		String input = null;
		while( !(input=br.readLine()).equals("0 0 0") ){
			String[] tok = input.split(" ");
			str += solve(Integer.parseInt(tok[0]),Integer.parseInt(tok[1]),Integer.parseInt(tok[2]) )+ ",";
		}
		String[] sol = str.substring(0,str.length()-1).split(",");
		for(int i=0; i<sol.length; i++)
			System.out.println(sol[i]);
	}
}