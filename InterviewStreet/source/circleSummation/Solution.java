/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package circleSummation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aakash
 */
public class Solution {

    static long[][][] result;

    /**
     * @param args the command line arguments
     */
    private static long[] getResult(int startIndex, long[] children, int m) {
        for (int i = startIndex, count = 0; count < m; i++, count++) {
            if (i == children.length) {
                i = 0;
            }
            children[i] += children[(i == 0 ? children.length - 1 : i - 1)] + children[(i == children.length - 1 ? 0 : i + 1)];
            // System.out.print(children[i]+" ");
        }
        return children;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;
        try {
            testCases = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
        }
        result = new long[testCases][][];
        for (int t = 0; t < testCases; t++) {
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }
            int N = Integer.parseInt(input.split(" ")[0]);
            int M = Integer.parseInt(input.split(" ")[1]);
            long[] children = new long[N];
            result[t] = new long[N][N];
            try {
                input = br.readLine();
            } catch (IOException ex) {
            }

            for (int n = 0; n < N; n++) {
                children[n] = Integer.parseInt(input.split(" ")[n]);
            }

            for (int i = 0; i < N; i++) {
                long[] clone = new long[children.length];
                System.arraycopy(children, 0, clone, 0, children.length);
                result[t][i] = getResult(i, clone, M);
                }
        }

        for (int t = 0; t < testCases; t++) {
            for (int i = 0; i < result[t].length; i++) {
                for (int j = 0; j < result[t][i].length; j++) {
                    System.out.print(result[t][i][j] % 1000000007 + " ");
                }
                System.out.println("");
            }
            if(t< testCases-1)     System.out.println("");
        }


    }
}
