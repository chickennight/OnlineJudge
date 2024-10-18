import java.util.*;
import java.io.*;

public class Main {

    static int K, R, C, X, Y, idx;
    static int[][] map;
    static boolean[][] visited;
    static int[] dir = new int[4];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        K = Integer.parseInt(in.readLine());

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2;
        }
        st = new StringTokenizer(in.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < dx.length; ++i)
            dir[i] = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        System.out.println(X + " " + Y);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[X][Y] = true;
        q.offer(new int[]{X, Y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < dx.length; ++i) {
                int d = dir[(idx + i) % 4];
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || nx >= R || 0 > ny || ny >= C || visited[nx][ny] || map[nx][ny] == 2) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                idx = (idx + i) % 4;
                X = nx;
                Y = ny;
                break;
            }
        }
    }
}