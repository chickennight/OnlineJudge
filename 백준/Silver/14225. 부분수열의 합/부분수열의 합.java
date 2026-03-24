// 14225 부분수열의 합

import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static final boolean[] num = new boolean[2000001];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        int result = 0;
        for (int i = 1; i < num.length; ++i) {
            if (!num[i]) {
                result = i;
                break;
            }
        }

        System.out.print(result);
    }

    private static void dfs(int idx, int sum) {
        if (idx == arr.length) {
            num[sum] = true;
            return;
        }

        dfs(idx + 1, sum + arr[idx]);

        dfs(idx + 1, sum);
    }

} 