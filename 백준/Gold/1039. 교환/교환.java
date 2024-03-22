import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int K;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        String N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        M = N.length();

        dp = new int[K + 1][1000001];

        System.out.println(DFS(N, 0));
    }

    private static int DFS(String str, int depth) {

        int num = Integer.parseInt(str);
        if (depth == K)
            return num;

        int target = dp[depth][num];
        if (target != 0)
            return target;

        target = -1;
        for (int i = 0; i < M - 1; ++i) {
            for (int j = i + 1; j < M; ++j) {
                if (i == 0 && str.charAt(j) == '0')
                    continue;

                String swapStr = swap(str, i, j);

                int temp = DFS(swapStr, depth + 1);
                target = Math.max(target, temp);
            }
        }

        dp[depth][num] = target;
        return dp[depth][num];
    }

    private static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
