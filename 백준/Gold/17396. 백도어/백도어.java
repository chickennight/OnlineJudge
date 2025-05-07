// 백도어

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visible = new boolean[N];
        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; ++i)
            if (Integer.parseInt(st.nextToken()) == 1)
                visible[i] = true;

        List<List<Node>> list = new ArrayList();

        for (int i = 0; i < N; ++i)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        long[] dist = new long[N];
        long MAX_VALUE = 9999999999L;
        Arrays.fill(dist, MAX_VALUE);

        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.idx == N - 1) break;
            if (dist[now.idx] < now.cost) continue;

            for (Node next : list.get(now.idx)) {

                if (visible[next.idx] && next.idx != N - 1)
                    continue;

                if (dist[next.idx] > dist[now.idx] + next.cost) {
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));

                }
            }

        }

        System.out.println(dist[N - 1] == MAX_VALUE ? "-1" : dist[N - 1]);
    }


}