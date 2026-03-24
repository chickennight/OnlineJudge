// 16947 서울 지하철 2호선

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[] isCycle;
    private static ArrayList<Integer>[] graphs;

    private static class Node {
        int cnt;
        int distance;

        public Node(int cnt, int distance) {
            this.cnt = cnt;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());

        isCycle = new boolean[N + 1];
        graphs = new ArrayList[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            graphs[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graphs[s].add(e);
            graphs[e].add(s);
        }

        for (int i = 1; i <= N; ++i)
            if (dfs(i, i, i))
                break;

        for (int i = 1; i <= N; ++i)
            if (!isCycle[i])
                dist[i] = bfs(i);

        for (int i = 1; i <= N; ++i)
            out.write(dist[i] + " ");

        out.flush();
        out.close();
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (isCycle[now.cnt]) {
                return now.distance;
            }
            for (int next : graphs[now.cnt]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, now.distance + 1));
                }
            }
        }

        return -1;
    }

    static boolean dfs(int start, int prev, int now) {
        isCycle[now] = true;

        for (int next : graphs[now]) {
            
            if (!isCycle[next]) {
                if (dfs(start, now, next)) {
                    return true;
                }
            } else if (prev != next && next == start) {
                return true;
            }
        }

        isCycle[now] = false;
        return false;
    }
}