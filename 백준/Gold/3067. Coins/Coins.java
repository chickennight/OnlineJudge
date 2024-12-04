import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(in.readLine());
            int[] arr = new int[n + 1];
            int[][] dp = new int[n + 1][10001];
            String[] s = in.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(s[j - 1]);
                dp[j][Integer.parseInt(s[j - 1])]++;
            }
            int target = Integer.parseInt(in.readLine());

            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= target; ++k) {
                    if (k - arr[j] < 0) {
                        dp[j][k] = dp[j - 1][k];
                        continue;
                    }
                    dp[j][k] += dp[j - 1][k] + dp[j][k - arr[j]];
                }
            }

            sb.append(dp[n][target]).append("\n");
        }
        System.out.println(sb);
    }

}