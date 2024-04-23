import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N + M; i++) {
            graph.add(new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[N + 1 + M];
        int[] distance = new int[N + 1 + M];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < K; ++j) {
                int temp = Integer.parseInt(st.nextToken());
                graph.get(temp).add(N + i + 1);
                graph.get(N + i + 1).add(temp);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        distance[1] = 1;

        while (!q.isEmpty()) {
            int start = q.poll();
            for (int end : graph.get(start)) {
                if (visited[end]) continue;
                visited[end] = true;
                distance[end] = distance[start] + 1;
                q.offer(end);
            }
        }

        System.out.println(visited[N] ? distance[N] / 2 + 1 : -1);
    }
}