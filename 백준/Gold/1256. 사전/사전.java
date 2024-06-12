import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[202][202];
        for (int i = 0; i <= 200; ++i) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 1; i <= 200; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                if (dp[i][j] > 1000000000)
                    dp[i][j] = 1000000001;
            }
        }

        if (dp[M + N][M] < K) {
            System.out.println("-1");
            return;
        }
        while (!(N == 0 && M == 0)) {
            if (dp[M + N - 1][M] >= K) {
                sb.append("a");
                --N;
            } else {
                sb.append("z");
                K -= dp[M + N - 1][M];
                --M;
            }
        }

        System.out.println(sb);
    }
}
