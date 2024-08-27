import java.io.*;
import java.util.*;

class Main {
    private static int M;
    private static List<List<Node>> crossWalk;
    private static long[] distance;

    static class Node implements Comparable<Node> {
        int index;
        long cost;

        Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        crossWalk = new ArrayList<>();
        for (int i = 0; i <= n; ++i)
            crossWalk.add(new ArrayList<>());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            crossWalk.get(u).add(new Node(v, i));
            crossWalk.get(v).add(new Node(u, i));
        }
        dijkstra();
        System.out.println(distance[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (currentNode.cost > distance[currentNode.index])
                continue;
            for (Node next : crossWalk.get(currentNode.index)) {
                int nextIndex = next.index;
                long nextCost;
                if (currentNode.cost <= next.cost)
                    nextCost = next.cost + 1;
                else
                    nextCost = ((long) Math.ceil(((double) currentNode.cost - next.cost) / M)) * M + next.cost + 1;

                if (nextCost < distance[nextIndex]) {
                    distance[nextIndex] = nextCost;
                    pq.offer(new Node(nextIndex, nextCost));
                }
            }
        }
    }

}
