import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static long result;
    static ArrayList<Edge>[] graph;
    static int cnt, n;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        graph = new ArrayList[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                int w = Integer.parseInt(st.nextToken());
                graph[i].add(new Edge(j, w));
            }
        }

        dijkstra();
        System.out.println(result);

    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.node])
                continue;

            visited[now.node] = true;

            result += now.weight;

            for (Edge next : graph[now.node]) {
                if (!visited[next.node]) {
                    pq.add(next);
                }
            }

            if (++cnt == n)
                break;

        }
    }


}
