import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int res = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = true;
        }

        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                if (i == k) continue;
                for (int j = 1; j <= N; ++j) {
                    if (i == j || j == k)
                        continue;
                    if (arr[i][k] && arr[k][j])
                        arr[i][j] = true;
                    
                }
            }
        }

        for (int i = 1; i <= N; ++i) {
            int cnt = 0;
            for (int j = 1; j <= N; ++j) {
                if (i == j)
                    continue;
                if (arr[i][j])
                    cnt++;
            }
            for (int j = 1; j <= N; ++j) {
                if (i == j)
                    continue;
                if (arr[j][i])
                    cnt++;
            }
            if (cnt == N - 1)
                res++;
        }
        System.out.println(res);
    }

}