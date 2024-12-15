import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        int INF = 987654321;
        int v, e;
        int[][] dist;
        List<List<Integer>> graph;

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            dist = new int[v + 1][v + 1];
            for (int i = 1; i <= v; ++i) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= v; ++i) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= e; ++i) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
                dist[a][b] = cost;
                dist[b][a] = cost;
            }

            for (int k = 1; k <= v; ++k) {
                for (int i = 1; i <= v; ++i) {
                    for (int j = 1; j <= v; ++j) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            int k = Integer.parseInt(in.readLine());
            int[] ans = new int[v + 1];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < k; ++i) {
                int startV = Integer.parseInt(st.nextToken());

                for (int j = 1; j <= v; ++j) {
                    ans[j] += dist[startV][j];
                }
            }

            int result = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 1; i <= v; ++i) {
                if (ans[i] < result) {
                    result = ans[i];
                    res = i;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}