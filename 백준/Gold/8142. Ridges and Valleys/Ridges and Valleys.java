import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ridges, valleys;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];

        ridges = 0;
        valleys = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ridges + " " + valleys);
    }

    private static void bfs(int x, int y, int height) {
        boolean isRidge = true, isValley = true;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int[] now;
        while (!q.isEmpty()) {
            now = q.poll();
            for (int[] d : directions) {
                int nx = now[0] + d[0];
                int ny = now[1] + d[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (!visited[nx][ny] && map[nx][ny] == height) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else if (map[nx][ny] < height) {
                    isValley = false;
                } else if (map[nx][ny] > height) {
                    isRidge = false;
                }

            }
        }
        if (isRidge) ridges++;
        if (isValley) valleys++;
    }
}