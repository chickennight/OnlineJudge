import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int half = (n / 2) + 1;
        while (m-- > 0) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = -1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= n; ++k) {
                    if (arr[k][i] != 0 && arr[j][i] == arr[i][k])
                        arr[j][k] = arr[j][i];
                }
            }
        }

        int[] big = new int[n + 1];
        int[] small = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (arr[i][j] == 1)
                    big[i]++;

                if (arr[i][j] == -1)
                    small[i]++;

            }
        }

        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (big[i] >= half) ans++;
            if (small[i] >= half) ans++;
        }

        System.out.println(ans);
    }
}