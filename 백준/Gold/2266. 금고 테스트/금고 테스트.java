import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        int ans;
        for (ans = 0; dp[K] < N; ++ans)
            for (int i = K; i > 0; --i)
                dp[i] += 1 + dp[i - 1];

        System.out.println(ans);

    }
}