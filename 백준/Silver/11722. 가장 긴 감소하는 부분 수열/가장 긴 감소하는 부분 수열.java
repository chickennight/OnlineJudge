import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int result = 0;

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}