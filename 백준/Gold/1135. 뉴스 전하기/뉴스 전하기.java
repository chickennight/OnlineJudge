import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] tree;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        dp = new int[n];
        tree = new ArrayList[n];

        for (int i = 0; i < n; ++i)
            tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        st.nextToken();
        for (int i = 1; i < n; ++i)
            tree[Integer.parseInt(st.nextToken())].add(i);

        System.out.println(dfs(0));
    }

    private static int dfs(int now) {
        int cnt = 0, max = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int next : tree[now]) {
            dp[next] = dfs(next);
            q.add(new int[]{next, dp[next]});
        }
        while (!q.isEmpty()) {
            int[] node = q.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }
        return max;
    }
}