import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Solution {
    private static double[] centre = {0,0};
    private static long[] cX;
    private static long[] cY;
    private static long [][] cord;
    static long  minTime;
    static int  cLen = 0;
        
    static void getData()
    {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        try {
            cord = new long[Integer.parseInt(br.readLine())][2];
        } catch (IOException ex) {
        }
        
        for (int i = 0; i < cord.length; i++) 
        {
            String input= null;
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }
            cord[i][0] = Integer.parseInt(input.split(" ")[0]);
            cord[i][1] = Integer.parseInt(input.split(" ")[1]);
            
            centre[0] += cord[i][0];
            centre[1] += cord[i][1];
           
        }
        centre[0] = centre[0]/cord.length;
        centre[1] = centre[1]/cord.length;
        
    }
    
    
    static void getCentroid()
    {
        long minDistance=0;
        for (int i = 0; i < cord.length; i++) 
        {
            long distance = (long) Math.sqrt( (Math.pow((cord[i][0] - centre[0]),2)) + (Math.pow((cord[i][1] - centre[1]),2)) );
            if(i==0 || distance < minDistance)      
            {
                minDistance = distance;
                cLen = 0;
                cX = new long[cord.length];
                cY = new long[cord.length];
                cX[cLen] = cord[i][0];
                cY[cLen] = cord[i][1];
        
            }
            else if(distance == minDistance)
            {
                cLen++;
                cX[cLen] = cord[0][0];
                cY[cLen] = cord[0][1];
            }
        }
    }
    
    static void  getMinTime()
    {
        for (int i = 0; i <= cLen; i++) 
        {   long time = 0;
            for (int j = 0; j < cord.length; j++) 
            {
                time += timeTaken(cord[j][0],cord[j][1],cX[i],cY[i]);
            }
            if(i== 0 )  minTime = time;
            else if(time < minTime)  minTime = time;
        }
    }
    
    private static long  timeTaken(long x, long y, long xC, long yC) 
    {
        long time =0;
        if(x== xC && y == yC)   return time;
        
        else if(Math.abs(xC-x)< Math.abs(yC-y))    
        {
            time += Math.abs(xC-x);
            time += Math.abs(yC-y) - Math.abs(xC-x);
        }
        else
        {
            time += Math.abs(yC-y);
            time += Math.abs(xC-x) - Math.abs(yC-y);
        }
   
        return time;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getData();
        getCentroid();
        getMinTime();
        System.out.print(minTime);
        
    }

    
}
