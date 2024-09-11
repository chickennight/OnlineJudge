import java.util.*;
import java.io.*;

public class Main {
    private static class Point implements Comparable<Point> {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point p) {
            return this.cnt - p.cnt;
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int N, min;
    private static boolean[][] map, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        map = new boolean[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            String str = in.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = str.charAt(j) == '0';
            }
        }

        min = Integer.MAX_VALUE;
        bfs();

        System.out.println(min);
    }

    private static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                min = now.cnt;
                break;
            }

            for (int d = 0; d < 4; ++d) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                int nc = now.cnt;

                if (outOfRange(nx, ny)) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if (map[nx][ny])
                    pq.add(new Point(nx, ny, nc + 1));
                else
                    pq.add(new Point(nx, ny, nc));

            }
        }
    }

    private static boolean outOfRange(int nx, int ny) {
        return 0 > nx || nx > N - 1 || 0 > ny || ny > N - 1;
    }

}
