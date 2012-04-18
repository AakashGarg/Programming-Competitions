/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package kDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Aakash
 */
public class Solution {
        static  int diff;
        static Integer[] arrList;
    
    static void getData()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException ex) {
        }
   
        int n = Integer.parseInt(s.split(" ")[0]);
        diff = Integer.parseInt(s.split(" ")[1]);
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
       
        String[] strings = null;
        try {
            strings = br.readLine().split(" ");
        } catch (IOException ex) {
        }
        
        for (int i = 0; i < n; i++) 
        {
            arrayList.add(Integer.parseInt(strings[i]));
        }
        
        Collections.sort(arrayList);
        arrList = (Integer[]) arrayList.toArray(new Integer[1]);
      
                       
    }
    
/*    static void printData()
    {
        for (int i = 0; i < arrList.length; i++) 
        {
            System.out.print(arrList[i]+" ");
        }
    }
    
  */  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        getData();
        int count = 0;
        
       for (int i = 0; i < arrList.length; i++) 
        {
            int a = arrList[i] + diff;
            int j=i;
            while(  j< arrList.length && arrList[j] < a)        j++;
            
        while( j< arrList.length && arrList[j] == a)      
            {
                count++;
                j++;
            }
            
        }
        
        System.out.print(count);
	
        
        
    }
}
