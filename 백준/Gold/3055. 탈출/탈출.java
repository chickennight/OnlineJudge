import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int R, C;
    private static char[][] map;
    private static int[][] hedgehogMoves;
    private static final Queue<int[]> waterQueue = new LinkedList<>();
    private static final Queue<int[]> hedgehogQueue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        hedgehogMoves = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                hedgehogMoves[i][j] = Integer.MAX_VALUE;

                if (map[i][j] == 'S') {
                    hedgehogQueue.offer(new int[]{i, j});
                    hedgehogMoves[i][j] = 0;
                } else if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int[] target = findTarget();
        int result = hedgehogMoves[target[0]][target[1]];
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    }

    private static void bfs() {
        while (!waterQueue.isEmpty() || !hedgehogQueue.isEmpty()) {
            int waterQSize = waterQueue.size();
            for (int i = 0; i < waterQSize; i++) {
                int[] water = waterQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = water[0] + dx[d];
                    int ny = water[1] + dy[d];
                    if (inBounds(nx, ny) && map[nx][ny] == '.' && map[nx][ny] != '*') {
                        map[nx][ny] = '*';
                        waterQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            int hedgehogQSize = hedgehogQueue.size();
            for (int i = 0; i < hedgehogQSize; i++) {
                int[] hedgehog = hedgehogQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = hedgehog[0] + dx[d];
                    int ny = hedgehog[1] + dy[d];
                    if (inBounds(nx, ny) && map[nx][ny] != '*' && map[nx][ny] != 'X' && hedgehogMoves[nx][ny] == Integer.MAX_VALUE) {
                        if (map[nx][ny] == 'D') {
                            hedgehogMoves[nx][ny] = hedgehogMoves[hedgehog[0]][hedgehog[1]] + 1;
                            return;
                        }
                        hedgehogMoves[nx][ny] = hedgehogMoves[hedgehog[0]][hedgehog[1]] + 1;
                        hedgehogQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static int[] findTarget() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean inBounds(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
