import java.io.*;
import java.util.*;

public class Main {

    private static long n;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(in.readLine());

        int[] hp = new int[N + 1];
        int[] happy = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; ++i) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; ++i) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[101][N + 1];

        for (int i = 1; i < 101; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (i > hp[j]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - hp[j]][j - 1] + happy[j]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[100][N]);
    }
}