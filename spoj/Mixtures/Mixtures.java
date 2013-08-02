import java.io.*;

class Mixtures{
	
	private static int[] sum;
	private static Integer[][] dp;

	private static void initArrays(int[] a){
		int N = a.length;
		sum = new int[N+1];
		dp = new Integer[N+1][N+1];
		for(int i=1; i<=N; i++)
			sum[i] = sum[i-1] + a[i-1];
	}
	
	private static int sum(int i, int j){
		return (sum[j]-sum[i-1])%100;
	}
	
	private static int[] toIntArray(String[] tok){
		int[] a = new int[tok.length];
		for(int i=0; i<a.length; i++)
			a[i] = Integer.parseInt(tok[i]);
		return a;
	}
	
	private static int minSmoke(int i, int j){
		if(i==j)		return 0;
		if(dp[i][j]==null){
			int min = Integer.MAX_VALUE;
			for(int k=i; k<j; k++){
				min = Math.min(minSmoke(i,k)+minSmoke(k+1,j)+sum(i,k)*sum(k+1,j), min);
			}
			dp[i][j] = min;
		}
		return dp[i][j];
	}
	
	public static int solve(int[] a){
		initArrays(a);
		return minSmoke(1,a.length);
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sol = "";
		String line = null;
		while( (line=br.readLine())!=null ){
			int N = Integer.parseInt(line);
			String[] tok = br.readLine().trim().split(" ");
			sol += solve(toIntArray(tok))+" ";
		}
		String[] tok = sol.trim().split(" ");
		for(int i=0; i<tok.length; i++)
			System.out.println(tok[i]);
	}
}
			