// 18405 경쟁적 전염

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    pq.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            q.add(pq.poll());
        }
        st = new StringTokenizer(in.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (S-- > 0) {
            int size = q.size();
            while (!q.isEmpty() && size-- > 0) {
                int[] now = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if (outOfRange(nx, ny, N)) continue;
                    if (map[nx][ny] > 0) continue;
                    map[nx][ny] = now[2];
                    q.add(new int[]{nx, ny, map[nx][ny]});
                }
            }
        }

        System.out.println(map[X - 1][Y - 1]);
    }

    private static boolean outOfRange(int x, int y, int N) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

