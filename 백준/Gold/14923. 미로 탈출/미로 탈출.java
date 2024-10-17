import java.util.*;
import java.io.*;

public class Main {

    private static class Move {
        int x, y, d;

        Move(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(in.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        boolean isPossible = false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Move> q = new LinkedList<>();
        visited[Hx][Hy][0] = true;
        q.offer(new Move(Hx, Hy, 0));
        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Move now = q.poll();

                if (now.x == Ex && now.y == Ey) {
                    isPossible = true;
                    break outer;
                }
                for (int d = 0; d < dx.length; ++d) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || (map[nx][ny] == 1 && now.d == 1))
                        continue;

                    if (!visited[nx][ny][now.d]) {
                        visited[nx][ny][now.d] = true;
                        q.offer(new Move(nx, ny, map[nx][ny] == 1 ? 1 : now.d));
                    }
                }
            }
            cnt++;
        }
        System.out.println(isPossible ? cnt : -1);
    }

}