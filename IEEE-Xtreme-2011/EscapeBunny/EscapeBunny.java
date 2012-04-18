import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class EscapeBunny {
        static String[] inputStrings;
    
    
    static int pos(int currPos, char move)
    {   int newPos=0;
        
        switch(move)
        {
            case 'U':   newPos = currPos/2;
                        break;
            
            case 'L':   newPos = currPos*2;
                        break;
            
            case 'R':   newPos = currPos*2+1;
                        break;
            
            case 'S':   newPos = currPos;
                        break;
            
            default:    System.out.println("got a invalid input");
                        break;
        }
       
    
        return newPos;    //returns new position on virtual move
    }
    
    public static void main(String[] args) {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        try {
            t = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
                //ERROR CAUGHT
        }
      
        inputStrings = new String[t];
        
        int k=0;
        while(t>0)
        {
            try {
                inputStrings[k++] = br.readLine();
            } catch (IOException ex) {
                   //ERROR CAUGHT
            }
            t--;
        }
        for(t=0; t<k; t++)
        {
            int noOfElmers = Integer.parseInt(inputStrings[t].split(" ")[0]);           //M
            int noOfMoves = Integer.parseInt(inputStrings[t].split(" ")[1]);            //N
            int bunnyStartPos = Integer.parseInt(inputStrings[t].split(" ")[2]);        //P0
            
            int[] currPosElmer = new int[noOfElmers];
            for(int i=0; i<noOfElmers; i++)
                currPosElmer[i] = 1;
            int currPosBunny = bunnyStartPos;
                 
            boolean caught = false;
            int i=0,j=0;
            for(i=0; i<noOfMoves; i++)
            {
                String currMove = inputStrings[t].split(" ")[i+3];
                
                for(j=0; j<noOfElmers; j++)
                {   
                    if(pos(currPosElmer[j], currMove.charAt(j+1)) == pos(currPosBunny, currMove.charAt(0)) )
                    {
                        caught = true;
                        break;
                    }
                    else
                        currPosElmer[j] = pos(currPosElmer[j], currMove.charAt(j+1));
                }
                if(caught == true)          break;
                else                        currPosBunny = pos(currPosBunny, currMove.charAt(0));
                 
                }
                
                if(caught == false)
                        System.out.print("0 0");
                else
                    System.out.print((i+1)+" "+(j+1));
                if(t<k-1)   System.out.println("");
                
        }
            
            
             
    }
        
        
}
