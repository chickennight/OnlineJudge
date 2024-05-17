import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 10_000_003;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] nums = new int[N];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, nums[i]);
        }

        long[][] dp = new long[N][max + 1];
        for (int i = 0; i < nums.length; ++i)
            dp[i][nums[i]]++;

        for (int i = 0; i < dp.length - 1; ++i) {
            for (int j = 1; j < dp[i].length; ++j) {
                if (dp[i][j] == 0)
                    continue;

                dp[i + 1][j] += dp[i][j];
                dp[i + 1][j] %= MOD;

                dp[i + 1][GCD(j, nums[i + 1])] += dp[i][j];
                dp[i + 1][GCD(j, nums[i + 1])] %= MOD;
            }
        }

        System.out.println(dp[N - 1][1]);
    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

}