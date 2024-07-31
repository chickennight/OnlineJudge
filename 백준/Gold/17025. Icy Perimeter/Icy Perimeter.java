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

    static int n, result, result2;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];
        result = Integer.MIN_VALUE;
        result2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i)
            arr[i] = in.readLine().toCharArray();

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                bfs(i, j);

        System.out.println(result + " " + result2);
    }

    static void bfs(int x, int y) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        if (visit[x][y] || arr[x][y] != '#')
            return;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        int cnt1 = 1;
        int cnt2 = 0;
        Point p;
        while (!q.isEmpty()) {
            p = q.poll();
            int cnt = 4;
            for (int d = 0; d < 4; ++d) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == '#')
                    cnt--;
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny] && arr[nx][ny] == '#') {
                    q.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    cnt1++;
                }
            }
            cnt2 += cnt;
        }

        if (result < cnt1) {
            result = cnt1;
            result2 = cnt2;
        } else if (result == cnt1) {
            result2 = Math.min(cnt2, result2);
        }
    }
}