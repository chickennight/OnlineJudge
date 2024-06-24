import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine().trim());
        int[][] index = new int[N + 1][2];
        StringTokenizer st;
        for (int i = 0; i < N + 1; ++i) {
            st = new StringTokenizer(in.readLine());
            index[i][0] = Integer.parseInt(st.nextToken());
            index[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dx = new int[]{0, -1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 0, -1, 1};
        long[][] dp = new long[N + 1][5];
        int si = index[0][0];
        int sj = index[0][1];
        for (int d = 0; d < 5; ++d)
            dp[1][d] = abs(si - (index[1][0] + dx[d])) + abs(sj - (index[1][1] + dy[d]));

        for (int i = 2; i < N + 1; ++i) {
            for (int da = 0; da < 5; ++da) {
                int nx = index[i][0] + dx[da];
                int ny = index[i][1] + dy[da];
                long dis = 200000L * i;
                if (inRange(nx, ny)) {
                    for (int db = 0; db < 5; ++db) {
                        int preX = index[i - 1][0] + dx[db];
                        int preY = index[i - 1][1] + dy[db];
                        dis = Math.min(dis, abs(nx - preX) + abs(ny - preY) + dp[i - 1][db]);
                    }
                }
                dp[i][da] = dis;
            }
        }

        long ans = dp[N][0];
        for (int d = 1; d < 5; ++d)
            ans = Math.min(ans, dp[N][d]);

        System.out.println(ans);
    }

    public static int abs(int i) {
        if (i < 0)
            return -i;
        return i;
    }

    public static boolean inRange(int i, int j) {
        return 0 <= i && i < 100000 && 0 <= j && j < 100000;
    }
}