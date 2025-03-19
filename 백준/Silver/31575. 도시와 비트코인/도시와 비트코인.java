// 31575 도시와 비트코인

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M == 0 && N == 0) {
            System.out.println("Yes");
        } else {
            int[][] map = new int[M][N];
            for (int i = 0; i < M; ++i) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] reachable = new int[M][N];
            reachable[0][0] = 1;
            for (int i = 1; i < M; ++i)
                if (map[i][0] == 1 && reachable[i - 1][0] > 0)
                    reachable[i][0] = reachable[i - 1][0] + 1;

            for (int i = 1; i < N; ++i)
                if (map[0][i] == 1 && reachable[0][i - 1] > 0)
                    reachable[0][i] = reachable[0][i - 1] + 1;

            for (int i = 1; i < M; ++i) {
                for (int j = 1; j < N; ++j) {
                    if (map[i][j] == 1)
                        reachable[i][j] = Math.max(reachable[i - 1][j], reachable[i][j - 1]) + 1;
                }
            }

            if (reachable[M - 1][N - 1] == M + N - 1) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}

