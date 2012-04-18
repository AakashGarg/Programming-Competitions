import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Solution {
    static int[][] points;
    static int[][] queryArr;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = "";
        try{
            points = new int[Integer.parseInt(br.readLine())][2];
            }catch(Exception ex){}
            
        for(int i=0; i< points.length; i++)
        {
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }
            points[i][0] = Integer.parseInt(input.split(" ")[0]);
            points[i][1] = Integer.parseInt(input.split(" ")[1]);
        }
        
        try {
            queryArr = new int[Integer.parseInt(br.readLine())][4];
        } catch (IOException ex) {
        }
        int k = 0;
       
        for (int i = 0; i < queryArr.length; i++) 
        {
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }
            char query = input.charAt(0);
            int startIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            int endIndex = Integer.parseInt(input.split(" ")[2]) - 1;
            
            switch(query)
            {
                case 'X':   for (int j = startIndex; j <= endIndex; j++)
                            {
                                points[j][1] *= -1; 
                            }
                            break;
                    
                case 'Y':   for (int j = startIndex; j <= endIndex; j++)
                            {
                                points[j][0] *= -1; 
                            }
                            break;
                    
                case 'C':   queryArr[k][0] = 0;
                            queryArr[k][1] = 0;
                            queryArr[k][2] = 0;
                            queryArr[k][3] = 0;
                            for (int j = startIndex; j <= endIndex; j++)
                            {
                                     if(points[j][0]>0 && points[j][1]>0)      queryArr[k][0]++;
                                else if(points[j][0]<0 && points[j][1]>0)      queryArr[k][1]++;
                                else if(points[j][0]<0 && points[j][1]<0)      queryArr[k][2]++;
                                else if(points[j][0]>0 && points[j][1]<0)      queryArr[k][3]++;
                            }
                            k++;
                            break;
            }
        }
        
        for (int i = 0; i < k; i++) 
        {
            for (int j = 0; j < 4; j++) 
            {
                System.out.print(queryArr[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
}
