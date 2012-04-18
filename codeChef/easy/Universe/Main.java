//package universe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        String iString = "";
        String input = " ";


        while (scanner.hasNextLine() && input.compareTo("42") != 0) {
            iString += input + " ";
            input = scanner.nextLine();

        }
        while (scanner.hasNextLine()) {
            scanner.nextLine();
        }


  //      System.out.println(iString);
        iString = iString.trim();

        for (int i = 0; i < iString.split(" ").length; i++) {
            System.out.println(iString.split(" ")[i]);
        }
    }
}
