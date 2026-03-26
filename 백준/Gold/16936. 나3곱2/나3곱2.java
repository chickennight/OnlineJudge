// 16936 나3곱2

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Long.parseLong(st.nextToken());

        BackTracking(0, new long[N], new boolean[N]);

    }

    private static boolean BackTracking(int depth, long[] ans, boolean[] visited) throws Exception {
        if (depth == N) {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < N; ++i)
                out.write(ans[i] + " ");
            out.flush();
            out.close();
            return true;
        }
        for (int i = 0; i < N; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[depth] = arr[i];
            if (depth == 0 || possible(ans[depth - 1], ans[depth]))
                if (BackTracking(depth + 1, ans, visited))
                    return true;
            visited[i] = false;
            ans[depth] = 0;
        }
        return false;
    }

    private static boolean possible(long a, long b) {
        return a == b * 3 || a * 2 == b;
    }


}