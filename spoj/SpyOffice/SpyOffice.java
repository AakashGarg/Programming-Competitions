import java.io.*;

class SpyOffice{
	
	public static double[] solve(int N, int[] D, int[] V, int[] T){
		double[] sol = new double[N];
		int[] Dsum = new int[N];
		for(int i=1; i<Dsum.length; i++)
			Dsum[i] = Dsum[i-1] + D[i];
		sol[0] = Double.MAX_VALUE;
		for(int i=1; i<N; i++)
			sol[i] = T[i] + D[i]*1.0/V[i] + Math.min(Dsum[i-1]*1.0/V[i],sol[i-1]);
		return sol;
	}
	
	private static int[] toIntArray(String[] tok){
		int[] a = new int[tok.length+1];
		for(int i=1; i<a.length; i++)
			a[i] = Integer.parseInt(tok[i-1]);
		return a;
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] D = toIntArray(br.readLine().split(" "));
		int[] T = new int[N];
		int[] V = new int[N];
		for(int i=1; i<N; i++){
			String[] tok = br.readLine().split(" ");
			T[i] = Integer.parseInt(tok[0]);
			V[i] = Integer.parseInt(tok[1]);
		}
		double[] sol = solve(N,D,V,T);
		for(int i=1; i<N; i++)
			System.out.println( (int) (sol[i]+0.4999));
	}
}