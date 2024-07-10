import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        long[] dp = new long[101];

        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;


        int[] arr = {1, 7, 4, 2, 0, 8};
        for (int i = 9; i <= 100; ++i) {
            for (int j = 2; j <= 7; ++j) {
                String temp = dp[i - j] + "" + arr[j - 2];
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(in.readLine());

            sb.append(dp[n]).append(" ");
            if (n % 2 == 0) {
                sb.append("1".repeat(Math.max(0, (n / 2))));
            } else {
                sb.append("7").append("1".repeat(Math.max(0, (n - 3) / 2)));
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}