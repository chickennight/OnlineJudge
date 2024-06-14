import java.util.*;
import java.io.*;

public class Main {

    static int[][] distance;
    static boolean[] visited;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new int[N + 1][N + 1];
        distance = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
            distance[a][b] = dist;
            distance[b][a] = dist;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b, N);
        }
    }

    public static void bfs(int start, int end, int nodeNum) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[nodeNum + 1];

        visited[start] = true;
        q.add(start);
        int[] ans = new int[nodeNum + 1];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= nodeNum; ++i) {

                if (node[now][i] == 1 && !visited[i]) {
                    ans[i] += distance[now][i] + ans[now];

                    if (i == end) {
                        System.out.println(ans[end]);
                        return;
                    }

                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
