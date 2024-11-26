import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());


        int[][][] dp = new int[101][101][2];

        dp[1][0][1] = 1;
        dp[1][0][0] = 1;

        for (int i = 0; i < 101; i++) {
            for (int j = 2; j < 101; j++) {
                dp[j][i][1] += dp[j - 1][i][0];
                if (i != 0) {
                    dp[j][i][1] += dp[j - 1][i - 1][1];
                }
                dp[j][i][0] += dp[j - 1][i][0] + dp[j - 1][i][1];
            }
        }
        
        StringTokenizer st;
        for (int i = 0; i < t; ++i) {
            st = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(dp[n][k][0] + dp[n][k][1]);
        }
    }

}