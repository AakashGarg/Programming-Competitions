import java.io.*;
import static java.lang.Math.*;
import java.util.Arrays;

class BtwnTheMntns{

	private static int solve(int[] m1, int[] m2){
		if(m1.length > m2.length){
			int[] temp = m1;
			m1 = m2;
			m2 = temp;
		}
		Arrays.sort(m2);	//sorting the larger array
		int min = Integer.MAX_VALUE;
		for(int i=0; i<m1.length; i++){
			int j = Arrays.binarySearch(m2,m1[i]);
			if(j>=0)		return 0;
			else{
				j = -1*(j+1);
				min = min((j==0?abs(m1[i]-m2[j]):min(abs(m1[i]-m2[j]),abs(m1[i]-m2[j-1]))) , min);
			}
		}
		return min;
	}
	
	private static int[] toIntArray(String[] tok){
		int[] arr = new int[tok.length-1];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(tok[i+1]);
		return arr;
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int[] sol = new int[T];
		for(int t=0; t<T; t++){
			String[] tok = br.readLine().trim().split(" ");
			int[] m1 = toIntArray(tok);
			tok = br.readLine().trim().split(" ");
			int[] m2 = toIntArray(tok);
			sol[t] = solve(m1,m2);
		}
		for(int i=0; i<sol.length; i++)
			System.out.println(sol[i]);
	}
}