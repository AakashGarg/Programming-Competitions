import java.io.*;

class Test{
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String line = null;
		while( (line=br.readLine())!=null && !line.equals("42"))
			input += line+" ";
		String[] tok = input.trim().split(" ");
		for(int i=0; i<tok.length; i++)
			System.out.println(tok[i]);
	}
}