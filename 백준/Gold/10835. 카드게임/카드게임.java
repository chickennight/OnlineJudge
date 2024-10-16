import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] left;
    static int[] right;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        left = new int[n];
        right = new int[n];
        dp = new int[n][n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            left[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            right[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);

        System.out.println(solution(0, 0));
    }

    static int solution(int l, int r) {
        if (l == n || r == n)
            return 0;

        if (dp[l][r] != -1)
            return dp[l][r];

        dp[l][r] = Math.max(solution(l + 1, r + 1), solution(l + 1, r));

        if (left[l] > right[r])
            dp[l][r] = Math.max(dp[l][r], solution(l, r + 1) + right[r]);

        return dp[l][r];
    }

}