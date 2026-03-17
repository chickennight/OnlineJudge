// 13398 연속합 2

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][2];

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(ans);
    }
}