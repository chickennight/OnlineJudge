// 1106 호텔

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < C + 101; ++j) {
                if (dp[j - people] != 1000000000) {
                    dp[j] = Math.min(dp[j], dp[j - people] + cost);
                }
            }
        }

        int result = 1000000000;
        for (int i = C; i < C + 101; ++i) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}