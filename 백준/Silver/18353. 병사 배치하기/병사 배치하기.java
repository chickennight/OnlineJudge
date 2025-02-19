// 18353 병사 배치하기

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine().trim());
        int[] soldier = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < N; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (soldier[i] >= soldier[j]) 
                    continue;
                
                dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(N - max);
    }
}