import java.util.*;
import java.io.*;

public class Main {

    static int n, answer, sd, ed;
    static int[][] map;
    static boolean[][][] visited;
    static ArrayList<int[]> start, end;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        visited = new boolean[n][n][2];
        start = new ArrayList<>();
        end = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String str = in.readLine();
            for (int j = 0; j < n; ++j) {
                char c = str.charAt(j);

                if (c == 'B') {
                    start.add(new int[]{i, j});
                } else if (c == 'E') {
                    end.add(new int[]{i, j});
                } else {
                    map[i][j] = c - '0';
                }
            }
        }

        prevCheck();
        bfs();
        System.out.println(answer);
    }

    public static void prevCheck() {
        int num = start.get(0)[0] - start.get(1)[0];

        if (num == 1 || num == -1)
            sd = 1;

        num = end.get(0)[0] - end.get(1)[0];

        if (num == 1 || num == -1)
            ed = 1;
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start.get(1)[0], start.get(1)[1], sd, 0});

        visited[start.get(1)[0]][start.get(1)[1]][sd] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int cnt = cur[3];

            if (x == end.get(1)[0] && y == end.get(1)[1] && dir == ed) {
                answer = cnt;
                return;
            }

            for (int d = 0; d < 4; ++d) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny, dir))
                    continue;

                if (visited[nx][ny][dir])
                    continue;

                if (treeCheck(nx, ny, dir))
                    continue;

                visited[nx][ny][dir] = true;
                q.offer(new int[]{nx, ny, dir, cnt + 1});
            }

            if (turn(x, y, dir)) {
                if (dir == 1) {
                    q.offer(new int[]{x, y, 0, cnt + 1});
                } else {
                    q.offer(new int[]{x, y, 1, cnt + 1});
                }
            }
        }
    }

    public static boolean treeCheck(int x, int y, int dir) {
        for (int i = -1; i <= 1; ++i) {
            if (dir == 1) {
                int nx = x + i;
                if (map[nx][y] == 1)
                    return true;
            } else {
                int ny = y + i;
                if (map[x][ny] == 1)
                    return true;
            }
        }
        return false;
    }

    public static boolean turn(int x, int y, int dir) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0)
                    continue;

                int nx = x + i;
                int ny = y + j;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (map[nx][ny] == 1)
                    return false;
            }
        }

        if (dir == 1) {
            dir = 0;
        } else {
            dir = 1;
        }

        if (inRange(x, y, dir) || treeCheck(x, y, dir))
            return false;

        if (visited[x][y][dir])
            return false;

        visited[x][y][dir] = true;

        return true;
    }

    public static boolean inRange(int x, int y, int dir) {
        if (dir == 1)
            return x <= 0 || x >= n - 1 || y < 0 || y >= n;
        else
            return x < 0 || x >= n || y <= 0 || y >= n - 1;

    }

}