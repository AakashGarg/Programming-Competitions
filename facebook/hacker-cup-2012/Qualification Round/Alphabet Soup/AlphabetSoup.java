import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class AlphabetSoup {

    static String[] inputStrings;

    static void getData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = 0;
        try {
            testcases = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
        }
        inputStrings = new String[testcases];
        for (int i = 0; i < testcases; i++) {
            try {
                inputStrings[i] = br.readLine();
            } catch (IOException ex) {
            }
        }
    }

    static void printResult(int testCase, int no) {
        System.out.println("Case #" + (testCase + 1) + ": " + no);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getData();
        // Solution starts here
        for (int t = 0; t < inputStrings.length; t++) {
            int maxCount = 1000;

            for (int i = 0; i < "HACKERCUP".length(); i++) {
                int count = 0, index = 0;

                for (int pos =0; index < inputStrings[t].length() && index != -1;) {
                    index = inputStrings[t].indexOf("HACKERCUP".charAt(i), pos);
                    if (index != -1)        count++;
                    pos = index+1;
                }

                if (count == 0) {
                    printResult(t, 0);
                    break;
                } else if (count < maxCount) {
                    maxCount = count;
                }
            }
            if (maxCount != 1000) {
                printResult(t, maxCount);
            }

        }

    }

}