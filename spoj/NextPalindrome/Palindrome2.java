import java.io.*;

class Palindrome2{

	private static char max(char a, char b){
		return(a-b>0 ? a : b);
	}
	
	private static char min(char a, char b){
		char ch = (a-b<0 ? a : b);
		if(ch<'9')		ch++;
		return ch;
	}

	public static String solve(char[] no){
		boolean flag = false;
		boolean changed = false;
		int k = 0;
		for(k=0; k<no.length && no[k]=='9'; k++);
		if(k==no.length){
			no = new char[no.length+1];
			no[0] = '1';
			for(int i=1; i<no.length; i++)
				no[i] = '0';
		}
		for(int i=no.length/2-1; i>=0; i--){
			int j = no.length-1-i;
			if(no[i] == no[j])			continue;
			if(flag)
				no[j] = no[i];
			else{
				if(no[j] < no[i])		no[j] = no[i];
				else{
					no[i] = no[j] = min(no[i],no[j]);
					flag = true;
				}
			}
			changed = true;
		}
		if(!changed){
			if(no[no.length/2]<'9')		no[no.length/2] += 1;
			else{
				no[no.length/2] = '0';
				int i=0;
				for(i=no.length/2-1; i>=0 && no[i]=='9'; i--)
					no[i] = no[no.length-1-i] = '0';
				no[i] = no[no.length-1-i] = min(no[i],no[no.length-1-i]);
			}
		}
		return String.valueOf(no);
	}

	public static void main(String... s) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++)
			System.out.println(solve(br.readLine().toCharArray()));
	}
}