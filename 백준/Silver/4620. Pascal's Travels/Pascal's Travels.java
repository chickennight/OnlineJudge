import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(in.readLine());
            if (n == -1) break;
            int[][] board = new int[n][n];
            for (int i = 0; i < n; ++i) {
                String line = in.readLine();
                for (int j = 0; j < n; ++j) {
                    board[i][j] = line.charAt(j) - '0';
                }
            }
            sb.append(countPaths(board, n)).append('\n');
        }
        System.out.println(sb);
    }

    public static long countPaths(int[][] board, int n) {
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dp[i][j] == 0 || board[i][j] == 0)
                    continue;

                int step = board[i][j];
                if (i + step < n) {
                    dp[i + step][j] += dp[i][j];
                }
                if (j + step < n) {
                    dp[i][j + step] += dp[i][j];
                }
            }
        }

        return dp[n - 1][n - 1];
    }
}