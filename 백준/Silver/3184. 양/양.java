import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;
    static int R;
    static int C;
    static int[] ans = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        int s = 0;
        int w = 0;

        for (int i = 0; i < R; ++i) {
            String temp = in.readLine();
            for (int j = 0; j < C; ++j) {
                map[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (!visit[i][j] && map[i][j] != '#') {
                    ans[0] = ans[1] = 0;
                    int[] x = dfs(i, j);
                    if (!(x[0] == 0 && x[1] == 0)) {
                        if (x[1] >= x[0]) {
                            w += x[1];
                        } else {
                            s += x[0];
                        }
                    }

                }
            }
        }
        System.out.println(s);
        System.out.println(w);
    }

    static int[] dfs(int x, int y) {

        visit[x][y] = true;
        if (map[x][y] == 'o')
            ans[0]++;
        if (map[x][y] == 'v')
            ans[1]++;

        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) 
                continue;
            if (visit[nx][ny] || map[nx][ny] == '#') 
                continue;
            dfs(nx, ny);
        }

        return ans;
    }
}