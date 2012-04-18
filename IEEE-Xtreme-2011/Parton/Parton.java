import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 *
 * @author Aakash
 */
public class Parton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = "";
        int leastSize = 0;
        int minCount = 0;
        int t = 0;
        try {

            leastSize = Integer.parseInt(br.readLine());
            minCount = Integer.parseInt(br.readLine());
            t = Integer.parseInt(br.readLine());
        } catch (Exception ex) {
        }


        while (t > 0) {
            try {
                inputString += br.readLine();
            } catch (IOException ex) {
                //exception caught
            }
            t--;
        }

        int freqCount = 0;
        //System.out.println(inputString);
       
        for (int i = 0; i < (inputString.length()) && (leastSize < inputString.length()); i++) 
        {
            HashSet<String> compList = new HashSet<String>();
            for (int k = 0,count =0; k < inputString.length()-leastSize+1 ; k++) 
            {       count = 0;   
                   // System.out.println("checking string : " + inputString.substring(k, k + leastSize));
                    if(compList.add(inputString.substring(k, k+leastSize))== true)
                    {   //System.out.println("found a new string");
                        for (int j = 0; j < inputString.length() - leastSize + 1; j++) 
                        {
                       // System.out.println("..............." + inputString.substring(j, j + leastSize));
                            if (inputString.substring(j, j + leastSize).compareTo(inputString.substring(k, k + leastSize)) == 0) {
                            count++;
                            }
                        }
                      //  System.out.println("count = "+count);
                    if (count >= minCount) 
                        freqCount += count;
                      //  System.out.println("freqCount = "+freqCount);
                    }
            }
            leastSize++;
        }
            System.out.print(freqCount);
        }
    }
