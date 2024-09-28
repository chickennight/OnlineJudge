import java.io.*;
import java.util.*;

class Main {

    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};

    private static boolean[][] visited, finished;
    private static int cnt;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String line = in.readLine();
            for (int j = 0; j < M; ++j) {
                int c = line.charAt(j);
                if (c == 'U') map[i][j] = 0;
                else if (c == 'D') map[i][j] = 1;
                else if (c == 'L') map[i][j] = 2;
                else if (c == 'R') map[i][j] = 3;
            }
        }

        visited = new boolean[N][M];
        finished = new boolean[N][M];
        cnt = 0;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited[i][j]) dfs(i, j);
            }
        }

        System.out.println(cnt);

    }


    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if (!visited[nx][ny]) {
            dfs(nx, ny);
        } else {
            if (!finished[nx][ny]) cnt++;
        }

        finished[x][y] = true;
    }

}
