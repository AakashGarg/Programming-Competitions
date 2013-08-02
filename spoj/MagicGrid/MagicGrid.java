import java.io.*;

class MagicGrid{
	public static int solve(int[][] S){
		int R = S.length;
		int C = S[0].length;
		for(int i=1; i<R; i++)
			S[i][0] += S[i-1][0];
		for(int j=1; j<C; j++)
			S[0][j] += S[0][j-1];
		for(int i=1; i<R; i++){
			for(int j=1; j<C; j++){
				S[i][j] += Math.max(S[i-1][j],S[i][j-1]);
			}
		}
/*		int i = R-1, j=C-1;
		int min = S[i][j];
		while(i>0 && j>0){
			if(S[i-1][j]>=S[i][j-1])			min = Math.min(S[--i][j],min);
			else								min = Math.min(S[i][--j],min);
		}
		if(i==0){
			while(j>=0)			min = Math.min(min,S[i][j--]);
		}else{
			while(i>=0)			min = Math.min(min,S[i--][j]);
		}
		return (min>0 ? 1 : 1-min);
	}
*/
		int min = min(S,R-1,C-1);
		return (min>0 ? 1 : 1-min);
	}
	
	private static int min(int[][] S, int i, int j){
		int min = S[i][j];
		while(i>0 && j>0){
			if(S[i-1][j]==S[i][j-1])			return Math.min(min,Math.max(min(S,i-1,j),min(S,i-1,j)));
			if(S[i-1][j]>=S[i][j-1])			min = Math.min(S[--i][j],min);
			else								min = Math.min(S[i][--j],min);
		}
		if(i==0){
			while(j>=0)			min = Math.min(min,S[i][j--]);
		}else{
			while(i>=0)			min = Math.min(min,S[i--][j]);
		}
		return min;
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