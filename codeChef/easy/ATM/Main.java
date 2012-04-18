/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ATM;

import java.io.BufferedReader;
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
        
        String iString= "";
        try {
            iString = br.readLine();
        } catch (Exception ex) {
        }
        
        int amount = Integer.parseInt(iString.split(" ")[0]);
        float balance = Float.parseFloat(iString.split(" ")[1]);
        
        if(amount%5 == 0 && amount+.5 <= balance )
            balance -= amount+.5;
        
        System.out.println(String.format("%.2f", balance));
        
        
    }
}
