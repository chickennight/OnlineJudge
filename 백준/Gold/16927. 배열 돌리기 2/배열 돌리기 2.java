import java.util.*;
import java.io.*;

public class Main {
    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};
    private static int N, M, R;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solve() {
        int min = Math.min(N, M) / 2;

        for (int i = 0; i < min; ++i) {
            int cnt = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
            rotate(i, cnt);
        }
    }

    static void rotate(int idx, int cnt) {
        for (int i = 0; i < cnt; ++i) {

            int x = idx;
            int y = idx;
            int temp = arr[y][x];

            int dir = 0;

            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < idx || ny < idx || nx >= M - idx || ny >= N - idx) {
                    dir++;
                    continue;
                }

                arr[y][x] = arr[ny][nx];
                y = ny;
                x = nx;
            }
            arr[idx + 1][idx] = temp;
        }
    }
}