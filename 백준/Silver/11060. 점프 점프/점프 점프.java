import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int[] arr = new int[1001];
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[1001];
        Arrays.fill(dp, 1001);
        dp[0] = 0;
        for (int i = 0; i < N; ++i) {
            int step = arr[i];
            for (int j = i + step; j > i; --j) {
                if (j < N) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        if (dp[N - 1] == 1001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}