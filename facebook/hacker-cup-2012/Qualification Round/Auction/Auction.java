import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Auction {

    public static int[][] inputData;
    public int[] price;
    public int[] weight;
    public int N, P1, W1, M, K, A, B, C, D;

    public Auction(int[] list) {
        this.N = list[0];
        this.P1 = list[1];
        this.W1 = list[2];
        this.M = list[3];
        this.K = list[4];
        this.A = list[5];
        this.B = list[6];
        this.C = list[7];
        this.D = list[8];

        price = new int[N];
        weight = new int[N];
        price[0] = P1;
        weight[0] = W1;

        for (int i = 1; i < N; i++) {
            price[i] = ((A * price[i - 1] + B) % M) + 1;
            weight[i] = ((C * weight[i - 1] + D) % K) + 1;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void getData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;
        try {
            testCases = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
        }
        inputData = new int[testCases][9];

        for (int t = 0; t < testCases; t++) {
            String[] input = null;
            try {
                input = br.readLine().split(" ");
            } catch (IOException ex) {
            }
            for (int i = 0; i < 9; i++) {
                inputData[t][i] = Integer.parseInt(input[i]);
            }

        }

    }

    static void printResult(int testCase, int terribles, int bargains) {
        System.out.println("Case #" + (testCase + 1) + ": " + terribles + " " + bargains);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        getData();
        for (int t = 0; t < inputData.length; t++) {
            Auction a = new Auction(inputData[t]);
            int bargains = 0, terribles = 0;

            for (int i = 0; i < a.N; i++) {

                int testPrice = a.price[i];
                int testWeight = a.weight[i];
                boolean foundABetter = false;
                boolean foundATerrible = false;

                for (int j = 0; j < a.N; j++) {
                    if (((a.price[j] < testPrice && a.weight[j] <= testWeight)
                            || (a.price[j] <= testPrice && a.weight[j] < testWeight)) == true) {
                        foundABetter = true;
                        break;
                    }

                }
                
                for (int j = 0; j < a.N; j++) {
                    if (((testPrice < a.price[j] && testWeight <= a.weight[j])
                            || (testPrice <= a.price[j] && testWeight < a.weight[j])) == true) {
                        foundATerrible = true;
                        break;
                    }

                }
                if (foundABetter == false) {
                    bargains++;
                }
                if (foundATerrible == false) {
                    terribles++;
                }
            }
            printResult(t, terribles, bargains);

        }
    }
}
