import java.io.*;

public class Main {

    private static char[] dna;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        dna = in.readLine().toCharArray();

        int[][] dp = new int[dna.length][dna.length];
        for (int length = 1; length < dna.length; length++) {
            for (int startIdx = 0; startIdx + length < dna.length; startIdx++) {
                int endIdx = startIdx + length;

                if (isKOI(startIdx, endIdx)) {
                    dp[startIdx][endIdx] = dp[startIdx + 1][endIdx - 1] + 2;
                }

                for (int midIdx = startIdx; midIdx < endIdx; midIdx++) {
                    dp[startIdx][endIdx] = Math.max(dp[startIdx][endIdx],
                            dp[startIdx][midIdx] + dp[midIdx + 1][endIdx]);
                }
            }
        }

        System.out.println(dp[0][dna.length - 1]);

    }

    static boolean isKOI(int startIdx, int endIdx) {
        return (dna[startIdx] == 'a' && dna[endIdx] == 't') || (dna[startIdx] == 'g' && dna[endIdx] == 'c');
    }
}