import java.util.*;
import java.io.*;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    private static int N, K;
    private static ArrayList<Edge>[] list;
    private static int[] minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        minCost = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            list[i] = new ArrayList<>();

        int max = 0;
        while (P-- > 0) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
            max = Math.max(max, c);
        }

        int start = 0;
        int answer = Integer.MIN_VALUE;

        while (start <= max) {
            int mid = (start + max) / 2;

            if (dijkstra(mid)) {
                answer = mid;
                max = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (answer == Integer.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private static boolean dijkstra(int x) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; ++i)
            minCost[i] = Integer.MAX_VALUE;

        minCost[1] = 0;
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge Edge = pq.poll();

            int now = Edge.end;
            int cost = Edge.cost;

            if (minCost[now] < cost) {
                continue;
            }

            for (Edge n : list[now]) {
                int next = n.end;
                int nextCost = cost;

                if (n.cost > x) {
                    nextCost += 1;
                }

                if (nextCost < minCost[next]) {
                    minCost[next] = nextCost;
                    pq.offer(new Edge(next, nextCost));
                }

            }
        }


        return minCost[N] <= K;
    }

}