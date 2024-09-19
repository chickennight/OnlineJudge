import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int N, M, H;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int startX = 0, startY = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            String input = st.nextToken();
            for (int j = 0; j < M; ++j) {
                if (input.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    map[i][j] = 11;
                } else if (input.charAt(j) == '.') {
                    map[i][j] = 0;
                } else if (input.charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = input.charAt(j) - '0';
                }
            }
        }

        bfs(startX, startY);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0, map[startX][startY] - 10});
        boolean[][] visit = new boolean[N][M];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int h = now[3];

            if (h > H) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 4; ++d) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] > 0 && map[nx][ny] <= h) {
                        q.clear();
                        q.add(new int[]{nx, ny, cnt + 1, h + 1});
                        map[nx][ny] = 0;
                        visit = new boolean[N][M];
                        break;
                    } else if (map[nx][ny] >= 0 && !visit[nx][ny]) {
                        q.add(new int[]{nx, ny, cnt + 1, h});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}