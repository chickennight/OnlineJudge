import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int match = Integer.parseInt(st.nextToken());
        int gap = Integer.parseInt(st.nextToken());
        int mismatch = Integer.parseInt(st.nextToken());

        String a = in.readLine();
        String b = in.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); ++i)
            dp[i][0] = dp[i - 1][0] + gap;
        for (int j = 1; j <= b.length(); ++j)
            dp[0][j] = dp[0][j - 1] + gap;

        for (int i = 1; i <= a.length(); ++i) {
            for (int j = 1; j <= b.length(); ++j) {
                int temp;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    temp = dp[i - 1][j - 1] + match;
                } else {
                    temp = dp[i - 1][j - 1] + mismatch;
                }

                dp[i][j] = Math.max(Math.max(dp[i - 1][j] + gap, dp[i][j - 1] + gap), temp);
            }
        }

        System.out.println(dp[a.length()][b.length()]);
    }
}