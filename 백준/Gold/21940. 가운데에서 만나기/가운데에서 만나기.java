import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static List<List<Node>> list;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; ++i)
            list.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e, w));
        }

        int k = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        int[] arr = new int[k];
        for (int i = 0; i < k; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 1; i <= n; ++i)
            dijkstra(i);


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int distance = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            int max = 0;
            for (int friend : arr) {
                int sum = dp[friend][i] + dp[i][friend];
                max = Math.max(max, sum);
            }

            if (max < distance) {
                pq.clear();
                pq.add(i);
                distance = max;
            } else if (max == distance) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
            sb.append(pq.poll()).append(" ");

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.add(new Node(start, 0));
        dp[start][start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dp[start][now.v] < now.w) continue;

            for (Node n : list.get(now.v)) {
                int dist = now.w + n.w;
                if (dp[start][n.v] > dist) {
                    dp[start][n.v] = dist;
                    pq.add(new Node(n.v, dist));
                }
            }
        }
    }
}