import java.util.*;
import java.io.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int nodeA;
        int nodeB;
        int distance;

        public Node(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Node> edges = new ArrayList<>();
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a - 1, b - 1, c));
        }

        Collections.sort(edges);
        int cnt = 0;
        int cost = 0;
        for (Node node : edges) {
            if (find(node.nodeA) != find(node.nodeB)) {
                cost += (cnt * t + node.distance);
                union(node.nodeA, node.nodeB);
                cnt++;
            }
        }

        System.out.println(cost);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
