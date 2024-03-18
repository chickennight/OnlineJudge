import java.io.*;
import java.util.*;

public class Main {
    
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int N, min, max;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int start = 0;
        int end = max - min;
        int answer = Integer.MAX_VALUE;
        boolean tf;
        while (start <= end) {

            int mid = (start + end) / 2;

            tf = false;
            for (int i = min; i <= max; ++i) {
                if (i <= map[0][0] && map[0][0] <= i + mid) {
                    if (bfs(i, i + mid)) {
                        tf = true;
                        break;
                    }
                }
            }

            if (tf) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else start = mid + 1;
        }

        System.out.println(answer);
    }

    static boolean bfs(int min, int max) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N - 1 && now.y == N - 1)
                return true;

            for (int d = 0; d < 4; ++d) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (inRange(nx, ny) && !visited[nx][ny] && min <= map[nx][ny] && map[nx][ny] <= max) {
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return false;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}