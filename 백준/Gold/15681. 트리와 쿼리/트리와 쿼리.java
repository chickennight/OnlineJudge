import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < list.length; ++i) 
            list[i] = new ArrayList<>();
        
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        dfs(r);
        StringBuffer sb = new StringBuffer();
        while (q-- > 0) {
            int query = Integer.parseInt(in.readLine());
            sb.append(dp[query]).append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int now) {

        if (dp[now] != 0) return dp[now];
        visited[now] = true;
        int count = 1;

        for (int node : list[now]) {
            if (visited[node]) continue;
            count += dfs(node);
        }
        dp[now] = count;

        return dp[now];
    }
}