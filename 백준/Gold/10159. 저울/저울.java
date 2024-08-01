import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        // 문제에서 주어진대로 입력을 받음.
        boolean[][] arr = new boolean[N + 1][N + 1];

        // 문제에서 주어진 것과 반대로 입력을 받음.
        boolean[][] reverse_arr = new boolean[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;
            reverse_arr[y][x] = true;
        }

        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (arr[i][k] && arr[k][j])
                        arr[i][j] = true;

                    if (reverse_arr[i][k] && reverse_arr[k][j])
                        reverse_arr[i][j] = true;

                }
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                arr[i][j] |= reverse_arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            int cnt = 0;
            for (int j = 1; j <= N; ++j) {
                if (i == j)
                    continue;

                if (!arr[i][j])
                    cnt++;

            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}