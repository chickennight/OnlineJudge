import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int city;
        long dist;

        public Edge(int loc, long dist) {
            this.city = loc;
            this.dist = dist;
        }

        public int compareTo(Edge o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Edge(u, dist));
        }

        long minDistance = 0;
        int minCity = 0;
        st = new StringTokenizer(in.readLine());
        long[] dist = new long[N + 1];
        Arrays.fill(dist, 100000000000L);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < K; ++i) {
            int start = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(start, 0));
            dist[start] = 0;
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int city = now.city;
            long distance = now.dist;

            if (dist[city] < distance)
                continue;

            for (Edge next : graph.get(city)) {
                int nextCity = next.city;
                long nextDistance = distance + next.dist;
                if (nextDistance < dist[nextCity]) {
                    dist[nextCity] = nextDistance;
                    pq.offer(new Edge(nextCity, nextDistance));
                }
            }
        }

        for (int i = 1; i <= N; ++i) {
            if (minDistance < dist[i]) {
                minDistance = dist[i];
                minCity = i;
            }
        }
        System.out.println(minCity);
        System.out.println(minDistance);
    }

}
