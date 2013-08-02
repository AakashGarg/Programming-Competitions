import java.io.*;

class Quadratics{
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tok = br.readLine().split(" ");
		int a = Integer.parseInt(tok[0]);
		int b = Integer.parseInt(tok[0]);
		int c = Integer.parseInt(tok[0]);
		int x = Integer.parseInt(br.readLine());
		System.out.println((a*x*x + b*x + c));
	}
}