import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            String s = in.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = bfs();

        System.out.println(ans);
    }

    static int bfs() {
        PriorityQueue<Pos> que = new PriorityQueue<>();
        int minDes = Integer.MAX_VALUE;

        que.add(new Pos(0, 0, 0));
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            Pos p = que.poll();
            int nowX = p.x;
            int nowY = p.y;

            if (nowX == N - 1 && nowY == M - 1) {
                minDes = p.cnt;
                return minDes;
            }

            for (int d = 0; d < 4; ++d) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (!isVisited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        que.add(new Pos(nx, ny, p.cnt));
                    }
                    if (map[nx][ny] == 1) {
                        que.add(new Pos(nx, ny, p.cnt + 1));
                    }
                    isVisited[nx][ny] = true;
                }
            }

        }
        return -1;
    }

}

class Pos implements Comparable<Pos> {
    int x, y, cnt;

    Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pos o) {
        return this.cnt - o.cnt;
    }
}