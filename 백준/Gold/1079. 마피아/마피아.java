import java.io.*;
import java.util.*;

public class Main {

    private static int N, me, ans = 0;
    private static int[] guilty;
    private static int[][] R;
    private static boolean[] dead;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        guilty = new int[N];
        R = new int[N][N];
        dead = new boolean[N];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            guilty[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; ++j) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        me = Integer.parseInt(in.readLine());
        game(N, 0);
        System.out.println(ans);
    }

    static void game(int cnt, int day) {
        if (dead[me] || cnt == 1) {
            ans = Math.max(ans, day);
            return;
        }

        if (cnt % 2 == 0) {
            for (int i = 0; i < N; ++i) {
                if (dead[i] || i == me)
                    continue;

                for (int j = 0; j < N; ++j) {
                    if (dead[j])
                        continue;
                    guilty[j] += R[i][j];
                }

                dead[i] = true;
                game(cnt - 1, day + 1);
                dead[i] = false;

                for (int j = 0; j < N; ++j) {
                    if (dead[j])
                        continue;
                    guilty[j] -= R[i][j];
                }
            }
        } else {
            int max = 0, idx = N - 1;

            for (int i = 0; i < N; ++i) {
                if (!dead[i] && max < guilty[i]) {
                    max = guilty[i];
                    idx = i;
                } else if (!dead[i] && max == guilty[i]) {
                    max = guilty[i];
                    idx = Math.min(i, idx);
                }
            }

            dead[idx] = true;
            game(cnt - 1, day);
            dead[idx] = false;
        }
    }
}