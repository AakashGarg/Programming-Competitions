/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package largeInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String iString="";
        try {
            iString = br.readLine();
        } catch (IOException ex) {
        }
        
        long n = Long.parseLong(iString.split(" ")[0]);
        long k = Long.parseLong(iString.split(" ")[1]);
        
        long count = 0;
        
        for (int i = 0; i < n; i++) 
        {
            int x=0;
            try {
                x = Integer.parseInt(br.readLine());
            } catch (IOException ex) {
            }
            if(x%k == 0)    count++;
        }
                System.out.println(count);
    }
}
