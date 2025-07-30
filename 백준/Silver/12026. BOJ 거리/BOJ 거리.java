// 12026 BOJ 거리

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        char[] arr = in.readLine().toCharArray();
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int min = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                if (arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = min;
                } else if (arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = min;
                } else if (arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = min;
                }

            }
        }
        System.out.println((dp[N - 1] == Integer.MAX_VALUE) ? -1 : dp[N - 1]);
    }
}