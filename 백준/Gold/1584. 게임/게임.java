// 1584 게임

import java.io.*;
import java.util.*;

public class Main {

    static final int SIZE = 501;
    static final int DANGER = 1, DEATH = 2;
    static int[][] zone = new int[SIZE][SIZE];
    static boolean[][] visited = new boolean[SIZE][SIZE];

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        fillArea(in, N, DANGER);
        int M = Integer.parseInt(in.readLine());
        fillArea(in, M, DEATH);
        System.out.println(bfs());
    }

    static void fillArea(BufferedReader in, int count, int type) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < count; ++i) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); ++j) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); ++k) {
                    zone[j][k] = type;
                }
            }
        }
    }

    static int bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.x == 500 && curr.y == 500)
                return curr.cost;

            for (int d = 0; d < 4; ++d) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                if (visited[nx][ny] || zone[nx][ny] == DEATH) continue;

                visited[nx][ny] = true;
                pq.offer(new Node(nx, ny, curr.cost + (zone[nx][ny] == DANGER ? 1 : 0)));
            }
        }

        return -1;
    }
}
