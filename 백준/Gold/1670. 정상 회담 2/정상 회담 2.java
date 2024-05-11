import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[] dp = new long[100001];
        final long MOD = 987654321;

        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j <= i - 2; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[n]);
    }


}