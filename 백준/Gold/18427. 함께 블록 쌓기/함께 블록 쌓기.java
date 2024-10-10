import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][1001];

        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= n; ++i)
            dp[i][0] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= h; ++j) {
                for (Integer integer : list[i]) {
                    if (j >= integer) {
                        dp[i][j] += dp[i - 1][j - integer];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[n][h]);

    }
}