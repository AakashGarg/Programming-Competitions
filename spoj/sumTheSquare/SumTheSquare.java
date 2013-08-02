import java.io.*;

class SumTheSquare{
	
	public static int f(int n){
		int sum = 0;
		while(n!=0){
			sum += (int) Math.pow(n%10,2);
		}
	}