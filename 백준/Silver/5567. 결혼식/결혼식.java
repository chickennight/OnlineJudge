import java.util.*;
import java.io.*;

public class Main {
    static int n, m, cnt;
    static ArrayList<Integer>[] friends;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        friends = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i)
            friends[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        visited = new int[n + 1];
        bfs();
        System.out.println(cnt);

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (visited[now] == 3)
                return;

            for (int next : friends[now]) {
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.offer(next);
                    cnt++;
                }
            }
        }
    }
}