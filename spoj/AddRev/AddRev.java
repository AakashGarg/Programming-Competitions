import java.io.*;

class AddRev{
	
	private static int reverse(String str){
		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length/2; i++){
			char ch = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = ch;
		}
		return Integer.parseInt(String.valueOf(arr));
	}
	
	public static int solve(String a, String b){
		return reverse(String.valueOf(reverse(a)+reverse(b)));
	}
	
	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++){
			String[] no = br.readLine().split(" ");
			System.out.println(solve(no[0],no[1]));
		}
	}
}