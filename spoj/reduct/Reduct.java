import java.io.*;

class Reduct{
	
	public static int solve(int a, int b, int c, int d){
		if(a>b){
			int t = a;
			a = b;
			b = t;
		}
		if(c>d){
			int t = c;
			c = d;
			d = t;
		}
		if(a<=c && b<=d)		return 100;
		if(b*c*1.0/a <= d)		return (int) (c*100.0/a);
		else					return (int) (d*100.0/b);
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while( !(line=br.readLine()).equals("0 0 0 0") ){
			String[] tok = line.split(" ");
			System.out.println(	solve(	Integer.parseInt(tok[0]), Integer.parseInt(tok[1]),
										Integer.parseInt(tok[2]), Integer.parseInt(tok[3])
									)+"%"
								);
		}
	}
}