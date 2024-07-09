import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i)
            adjList[i] = new ArrayList<>();

        int a, b;
        while (M-- > 0) {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }

        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        int cnt = 0;
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        visited[X] = 0;
        while (!q.isEmpty() && depth < K) {
            int size = q.size();
            while (size-- > 0) {
                int now = q.poll();
                for (int next : adjList[now]) {
                    if (visited[next] == -1) {
                        visited[next] = visited[now] + 1;
                        q.offer(next);
                    }
                }
            }
            depth++;
        }

        if (depth < K || (depth == K && q.isEmpty()))
            System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; ++i)
                if (visited[i] == K)
                    sb.append(i).append('\n');

            System.out.println(sb);
        }
    }
}