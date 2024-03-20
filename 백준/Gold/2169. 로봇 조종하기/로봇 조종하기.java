import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mars = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int[][] temp = new int[2][M + 2];

        int i, j;
        for (i = 1; i <= N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (j = 1; j <= M; ++j) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = mars[1][1];

        for (i = 2; i <= M; ++i)
            dp[1][i] = mars[1][i] + dp[1][i - 1];

        for (i = 2; i <= N; ++i) {

            temp[0][0] = dp[i - 1][1];
            for (j = 1; j <= M; ++j)
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + mars[i][j];

            temp[1][M + 1] = dp[i - 1][M];
            for (j = M; j >= 1; --j)
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + mars[i][j];

            for (j = 1; j <= M; ++j)
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);

        }

        System.out.println(dp[N][M]);

        in.close();
    }

}