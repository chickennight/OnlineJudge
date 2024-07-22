import java.io.*;
import java.util.*;

public class Main {

    static int n, m, max;
    static boolean isCycle;
    static int[][] dp;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m];
        map = new char[n][m];
        visited = new boolean[n][m];
        isCycle = false;

        for (int i = 0; i < n; ++i)
            map[i] = in.readLine().toCharArray();

        visited[0][0] = true;
        dfs(0, 0, 1);
        if (isCycle) {
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
    }

    static void dfs(int x, int y, int moveCount) {
        if (isCycle) return;

        int move = map[x][y] - '0';
        dp[x][y] = moveCount;
        if (moveCount > max) {
            max = moveCount;
        }

        for (int d = 0; d < dx.length; ++d) {
            int nx = x + (move * dx[d]);
            int ny = y + (move * dy[d]);

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;

            if (map[nx][ny] == 'H')
                continue;

            if (moveCount < dp[nx][ny])
                continue;

            if (visited[nx][ny]) {
                isCycle = true;
                return;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, moveCount + 1);
            visited[nx][ny] = false;

        }
    }
}