import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class BloomFilter {
    //static HashSet<String> inputSet = new HashSet<String>();
    static boolean[] filter = {false, false,false,false,false,false,false,
                                false,false,false,false,false,false,false,
                                false,false,false,false,false,false,false,
                                false,false,false,false,false};
    static String[] iString;
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString="";
        try {
            inputString = br.readLine();
        } catch (IOException ex) {
            //exception caught
        }
        

        inputString = inputString.toUpperCase();
        inputString = inputString.replace('.',' ');
        inputString = inputString.replaceAll(";","");
        inputString = inputString.replace('?',' ');
        inputString = inputString.replaceAll("!","");
        inputString = inputString.replaceAll("\n"," ");
        
        for(int i=0; i<inputString.length(); i++)
        {   char iC = inputString.charAt(i);
            if(iC>='A' && iC<='Z')
                    filter[iC-'A'] = true;
           
        }
        
        try {
            iString = br.readLine().toUpperCase().split(" ");
        } catch (IOException ex) {
//exception caught;
        }
        int wordCount=0;
        for (int i = 0; i < iString.length; i++) 
        {
            boolean test = true;
            for(int j=0; j< iString[i].length(); j++)
            {
                if(  filter[iString[i].charAt(j)-'A']== false)
                {
                    test = false;
                    break;
                }
            }
            if(test == true)        wordCount++;
        }
        System.out.println(wordCount);
    
        
        
    }
}
