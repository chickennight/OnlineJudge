import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1000000007;
    private static long[][] D;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        D = new long[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i == 0 || j == 0) D[i][j] = 0;
                else D[i][j] = -1;
            }
        }
        D[1][1] = 1;

        System.out.println(dp(n, m) % MOD);
    }

    private static long dp(int n, int m) {
        if (D[n][m] != -1) return D[n][m];
        return D[n][m] = (dp(n, m - 1) + dp(n - 1, m) + dp(n - 1, m - 1)) % MOD;
    }
}