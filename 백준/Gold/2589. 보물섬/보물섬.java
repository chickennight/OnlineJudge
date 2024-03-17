import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static final int[] moveY = {-1, 0, 1, 0};
    static final int[] moveX = {0, 1, 0, -1};
    static int R, C;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; ++i)
            arr[i] = in.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (arr[i][j] == 'L') {
                    visit = new boolean[R][C];
                    answer = Math.max(answer, bfs(i, j));

                }
            }
        }

        System.out.println(answer);

    }

    private static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        int result = 0;
        visit[i][j] = true;
        q.add(new Point(j, i, 0));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int d = 0; d < 4; ++d) {
                int nx = now.x + moveX[d];
                int ny = now.y + moveY[d];
                if (0 <= nx && nx < C && 0 <= ny && ny < R && !visit[ny][nx] && arr[ny][nx] == 'L') {
                    visit[ny][nx] = true;
                    q.add(new Point(nx, ny, now.cnt + 1));
                    result = Math.max(result, now.cnt + 1);
                }
            }
        }
        return result;
    }

}