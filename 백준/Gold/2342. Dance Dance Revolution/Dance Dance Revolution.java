import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    static ArrayList<Integer> list;
    static int size;
    static int[][] width = {
            {1, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        list = new ArrayList<>();
        while (true) {
            int n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;

            list.add(n);
        }
        size = list.size();
        dp = new int[size][5][5];
        System.out.println(solve(0, 0, 0));
    }

    private static int solve(int idx, int l, int r) {
        if (idx == size)
            return 0;

        if (dp[idx][l][r] != 0)
            return dp[idx][l][r];

        int next = list.get(idx);
        dp[idx][l][r] = Math.min(solve(idx + 1, next, r) + width[l][next], solve(idx + 1, l, next) + width[r][next]);

        return dp[idx][l][r];
    }
}
