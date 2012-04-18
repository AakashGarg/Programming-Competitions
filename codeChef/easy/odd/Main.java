/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package odd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Main {
        static long[] pos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=0;
        try {
            T = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
        }
        pos = new long[T];
        
        for(int t=0; t<T; t++ )
        {
            long n = 0;
            try {
                n = Long.parseLong(br.readLine());
            } catch (IOException ex) {
            }
            pos[t] = 1;
            for (long i = 1; i <= n; i++) 
            {
                if(n/(pos[t]*2) == 0)   break;
                pos[t] *= 2;
            }
            
        }
        
        for (int i = 0; i < T; i++) 
        {
            System.out.println(pos[i]);
        }
        
    }
}
