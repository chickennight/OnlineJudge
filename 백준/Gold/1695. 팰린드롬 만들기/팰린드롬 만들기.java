import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] numbers;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            numbers[i] = Integer.parseInt(st.nextToken());

        dp = new int[N][N];
        for (int[] n : dp)
            Arrays.fill(n, -1);

        int l = 0;
        int r = N - 1;
        System.out.println(solve(l, r));
    }

    static int solve(int l, int r) {
        if (l > r)
            return 0;

        if (dp[l][r] != -1)
            return dp[l][r];

        if (numbers[l] == numbers[r])
            dp[l][r] = solve(l + 1, r - 1);
        else
            dp[l][r] = Math.min(solve(l + 1, r) + 1, solve(l, r - 1) + 1);

        return dp[l][r];
    }
}
