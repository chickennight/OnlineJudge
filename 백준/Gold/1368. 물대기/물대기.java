import java.io.*;
import java.util.*;

public class Main {
    private static class Edge implements Comparable<Edge> {
        int nodeA, nodeB, distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.distance, e.distance);
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        parent = new int[301];

        int N = Integer.parseInt(in.readLine());

        for (int i = 1; i <= N; ++i)
            parent[i] = i;

        int[] nodeCost = new int[301];
        for (int i = 1; i <= N; ++i)
            nodeCost[i] = Integer.parseInt(in.readLine());

        ArrayList<Edge> edges = new ArrayList<>();
        StringTokenizer st;
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; ++j) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j)
                    edges.add(new Edge(0, j, nodeCost[i]));
                else if (i < j)
                    edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges);

        int min = 0;

        for (Edge edge : edges) {
            int nodeA = edge.nodeA;
            int nodeB = edge.nodeB;
            int cost = edge.distance;

            if (find(nodeA) != find(nodeB)) {
                union(nodeA, nodeB);
                min += cost;
            }
        }

        System.out.println(min);

    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;

    }

}