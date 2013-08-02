import java.io.*;

class MagicGrid2{
	public static int solve(int[][] S){
		int R = S.length;
		int C = S[0].length;
		int[][] sol = new int[R][C];
		sol[R-1][C-1] = 1;
		for(int i=R-2; i>=0; i--)
			sol[i][C-1] = sol[i+1][C-1]-S[i][C-1];
		for(int j=C-2; j>=0; j--)
			sol[R-1][j] = sol[R-1][j+1]-S[R-1][j];
		for(int i=R-2; i>=0; i--){
			for(int j=C-2; j>=0; j--){
				sol[i][j] = Math.min(sol[i+1][j],sol[i][j+1]) - S[i][j];
				if(sol[i][j]<1)		sol[i][j] = 1;
			}
		}
		return sol[0][0];
	}
	
	private static int[] toIntArray(String[] tok){
		int[] a = new int[tok.length];
		for(int i=0; i<tok.length; i++)
			a[i] = Integer.parseInt(tok[i]);
		return a;
	}
	
	public static void main(String... s) throws IOException{
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			int[] sol = new int[T];
			for(int t=0; t<T; t++){
				String[] tok = br.readLine().trim().split(" ");
				int R = Integer.parseInt(tok[0]);
				int C = Integer.parseInt(tok[1]);
				int[][] S = new int[R][C];
				for(int i=0; i<R; i++)
					S[i] = toIntArray(br.readLine().trim().split(" "));
				sol[t] = solve(S);
			}
			for(int i=0; i<sol.length; i++)
				System.out.println(sol[i]);
		}catch(IOException e){
		}
	}
}