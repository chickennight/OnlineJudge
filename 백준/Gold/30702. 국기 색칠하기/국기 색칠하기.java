// 30702 국기 색칠하기

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static char[][] flagA, flagB;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        flagA = new char[N][M];
        flagB = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) flagA[i] = in.readLine().toCharArray();
        for (int i = 0; i < N; i++) flagB[i] = in.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && !isSame(i, j)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static boolean isSame(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        char originalA = flagA[x][y];
        char originalB = flagB[x][y];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0], nowY = now[1];

            if (flagB[nowX][nowY] != originalB) return false;

            for (int d = 0; d < 4; ++d) {
                int nx = nowX + dx[d], ny = nowY + dy[d];
                if (outOfRange(nx, ny) || visited[nx][ny]) continue;
                if (flagA[nx][ny] == originalA) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return true;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}

