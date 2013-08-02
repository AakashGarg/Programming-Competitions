import java.io.*;

class HelpYon{
	private static Double[][] dp;
	private static int[] BSumPrice;
	private static int[] DSum;
	
/*
	private static int cost(int i, int j){
		if(i>=j)	dp[i][j] = 0;
		else if(dp[i][j]==null){
			if(j-i == 1)	dp[i][j] = (BSumPrice[j-1]-BSumPrice[i-1])*(DSum[j]-DSum[i-1]);
			else{
				for(int k=i+1; k<j; k++){
//					System.out.println(i+","+j+","+k);
					int cost = cost(i,k)+cost(k,j)+(BSumPrice[k-1]-BSumPrice[i-1])*(DSum[j]-DSum[k-1]);
					dp[i][j] = (dp[i][j]==null ? cost : Math.min(cost,dp[i][j]) );
				}
			}
		}
//		System.out.println(i+","+j+" = "+dp[i][j]);
		return dp[i][j];
	}
*/
	
	public static double cost(int s, int N){
		for(int i=0; i<=N; i++){
			for(int j=0; j<=N; j++){
				dp[i][j] = (i>=j? 0.0 : Double.POSITIVE_INFINITY);
			}
		}
		for(int l=2; l<=N; l++){
			for(int i=1; i<=N-l+1; i++){
				int j = i+l-1;
				for(int k=i; k<=j; k++){
					dp[i][j] = Math.min(dp[i][k]+dp[k][j]+(BSumPrice[k-1]-BSumPrice[i-1])*(DSum[j]-DSum[k-1]),dp[i][j]);
				}
			}
		}
		return dp[1][N];
	}
	
	public static int solve(int[] V, int[] D, int N, int valMax){
		dp = new Double[N+1][N+1];
		for(int i=0; i<=N; i++)
			dp[i][i] = 0.0;
		BSumPrice = new int[N+1];
		DSum = new int[N+1];
		for(int i=0; i<N; i++)
			BSumPrice[i+1] = BSumPrice[i] + V[i];
		for(int i=0; i<N; i++)
			DSum[i+1] = DSum[i] + D[i];
		cost(1,N);
		int max = 0;
		for(int i=1; i<=N; i++){
			for(int j=i; j<=N; j++){
				System.out.print(dp[i][j]+" ");
				if(dp[i][j]<=valMax)			max = Math.max(max,j-i);
			}
			System.out.println();
			for(int k=0; k<i; k++)
				System.out.print("0 "); 
		}
		return max;
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tok = br.readLine().split(" ");
		int N = Integer.parseInt(tok[0]);
		int valMax = Integer.parseInt(tok[1]);
		int[] D = new int[N+1];
		int[] V = new int[N+1];
		for(int i=1; i<=N; i++){
			tok = br.readLine().split(" ");
			D[i] = Integer.parseInt(tok[0]);
			V[i] = Integer.parseInt(tok[1]);
			D[i] = D[i] - D[1];
		}
		System.out.println(solve(V,D,N,valMax));
	}
}