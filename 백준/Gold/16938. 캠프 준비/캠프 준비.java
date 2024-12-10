import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static boolean[] visited;
    private static int ans, l, r, x;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        ans = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; ++i)
            combination(0, i);

        System.out.println(ans);
    }

    private static void combination(int start, int idx) {
        if (idx == 0) {

            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; ++i) {
                if (visited[i]) {
                    sum += arr[i];
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            }

            if (sum >= l && sum <= r && max - min >= x)
                ans++;

            return;
        }

        for (int i = start; i < arr.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, idx - 1);
                visited[i] = false;
            }
        }
    }


}