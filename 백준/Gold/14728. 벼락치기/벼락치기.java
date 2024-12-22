import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] input = new int[N + 1][2];
        int[][] dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(in.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= T; ++j) {
                if (j >= input[i][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - input[i][0]] + input[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][T]);
    }

}