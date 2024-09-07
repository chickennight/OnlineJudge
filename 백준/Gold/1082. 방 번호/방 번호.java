import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(in.readLine());
        int[] dp = new int[100];
        int cost = 0;
        int idx = 0;
        int minIdx = findMin(0);
        if (minIdx == 0) {
            minIdx = findMin(1);
            if (arr[minIdx] <= M) {
                dp[idx++] = minIdx;
                cost += arr[minIdx];
                minIdx = 0;
            } else {
                System.out.println(0);
                return;
            }
        }
        while (cost + arr[minIdx] <= M) {
            dp[idx++] = minIdx;
            cost += arr[minIdx];
        }
        for (int i = 0; i < idx; ++i) {
            for (int j = N - 1; j >= 0; --j) {
                if (cost - arr[dp[i]] + arr[j] <= M) {
                    cost = cost - arr[dp[i]] + arr[j];
                    dp[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; ++i)
            sb.append(dp[i]);

        System.out.println(sb);
    }

    public static int findMin(int start) {
        int idx = 0, min = 100;
        for (int i = start; i < N; ++i) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        return idx;
    }


}