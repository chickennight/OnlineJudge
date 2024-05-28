import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];
        int[][] w = new int[n][m + 1];
        int[][] h = new int[n + 1][m];

        int k = Integer.parseInt(in.readLine());
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (b == d)
                w[Math.min(a, c)][b] = 1;
            else
                h[a][Math.min(b, d)] = 1;


        }

        for (int i = 1; i < n + 1; ++i) {
            if (w[i - 1][0] == 1)
                break;
            dp[i][0] = 1L;
        }
        for (int i = 1; i < m + 1; ++i) {
            if (h[0][i - 1] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

                if (w[i - 1][j] == 1)
                    dp[i][j] -= dp[i - 1][j];

                if (h[i][j - 1] == 1)
                    dp[i][j] -= dp[i][j - 1];

            }
        }

        System.out.println(dp[n][m]);

    }
}