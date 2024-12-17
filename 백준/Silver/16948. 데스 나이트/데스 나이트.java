import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int n, cnt;
    private static final int[] dx = {-2, -2, 0, 0, 2, 2};
    private static final int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());


        StringTokenizer st = new StringTokenizer(in.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1, r2, c2);

    }

    private static void bfs(int r1, int c1, int r2, int c2) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r1, c1, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == r2 && now.y == c2) {
                System.out.println(now.cnt);
                return;
            }
            for (int d = 0; d < 6; ++d) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (isRange(nx, ny) && !visited[nx][ny]) {
                    q.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= n && y <= n;
    }
}
