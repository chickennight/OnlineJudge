import java.util.*;
import java.io.*;

public class Main {
    static private int[] dp, arr;
    static private int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(in.readLine());

        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        System.out.println(dfs(0));
    }

    private static int dfs(int idx) {
        if (dp[idx] < Integer.MAX_VALUE) 
            return dp[idx];
        
        int k = m - arr[idx];
        for (int i = idx + 1; i <= n && k >= 0; ++i) {
            if (i == n) {
                dp[idx] = 0;
                break;
            }
            dp[idx] = Math.min(dp[idx], (k * k) + dfs(i));
            k -= arr[i] + 1;
        }
        return dp[idx];
    }
}