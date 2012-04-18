import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Billboards {

    int W;
    int H;
    String[] words;

    public Billboards(String[] input) {
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);
        words = new String[input.length - 2];
        for (int i = 2; i < input.length; i++) {
            words[i - 2] = input[i];
        }

    }

    public int getFontSize() {
        int numOfWords = words.length;
        int maxLength = Integer.MIN_VALUE;

        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        int FONT_MAX_SIZE = Math.max(H / numOfWords, W / maxLength);

        for (int font = FONT_MAX_SIZE; font >= 1; font--) {
            int rows = H / font;
            int cols = W / font;
            if (canFill(rows, cols, words)) {
                return font;
            }
        }
        return -1;
    }

    private boolean canFill(int maxRows, int maxColumns, String[] words) {

        int k = 0;
        for (int rows = 0; k < words.length && rows < maxRows; rows++) {

            for (int sum = 0; k < words.length && (sum + words[k].length() <= maxColumns); k++) {
                sum += words[k].length();
		sum += ((sum < maxColumns - 1) ? 1 : 0);
            }
        }
        if (k == words.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String... args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=0;
        try {
            testCases = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
        }

        for (int t = 0; t < testCases; t++) {
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }
            Billboards b = new Billboards(input.split(" "));
            int fontSize = b.getFontSize();
            if (fontSize != -1) {
                printResult(t, fontSize);
            }
        }

    }

    static private void printResult(int i, int c) {
        System.out.println("Case #" + (i+1) + ": " + c);
    }
}