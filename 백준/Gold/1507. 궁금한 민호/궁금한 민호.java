import java.util.*;
import java.io.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        final int MAX = 50001;
        int[][] base = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; ++j) {
                base[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] costs = copy(base);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    if (costs[j][k] == costs[j][i] + costs[i][k] && (j != k && k != i && j != i)) {
                        costs[j][k] = MAX;
                        costs[k][j] = MAX;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (costs[i][j] != MAX) {
                    ans += costs[i][j];
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                }
            }
        }

        if (isSame(costs, base)) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }


    }

    private static int[][] copy(int[][] base) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; ++i)
            System.arraycopy(base[i], 0, result[i], 0, N);

        return result;
    }

    private static boolean isSame(int[][] costs, int[][] base) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (costs[i][j] != base[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}