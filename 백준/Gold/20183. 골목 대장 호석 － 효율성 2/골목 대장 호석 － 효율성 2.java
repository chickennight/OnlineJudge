import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end;
        long weight;

        public Edge(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static int A, B, N, M;
    static long answer, C;
    static long[] dist;
    static List<Edge>[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        dist = new long[N + 1];
        array = new ArrayList[N + 1];

        for (int i = 0; i <= N; ++i)
            array[i] = new ArrayList<>();

        long max = Long.MIN_VALUE;

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            max = Math.max(max, c);

            array[a].add(new Edge(b, c));
            array[b].add(new Edge(a, c));
        }

        answer = binary(max);
        System.out.println(answer);
    }

    static private long binary(long max) {
        long answer = -1, l = 0, r = max, mid;

        while (l <= r) {
            mid = (l + r) / 2;
            if (!Dijkstra(mid))
                l = mid + 1;
            else {
                answer = mid;
                r = mid - 1;
            }
        }

        return answer;
    }

    static private boolean Dijkstra(long cost) {
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(A, 0));
        dist[A] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (dist[now.end] < now.weight)
                continue;

            for (Edge next : array[now.end]) {
                if (cost >= next.weight && dist[next.end] > dist[now.end] + next.weight) {
                    dist[next.end] = dist[now.end] + next.weight;
                    pq.add(new Edge(next.end, dist[next.end]));
                }
            }
        }

        return dist[B] <= C;
    }

}