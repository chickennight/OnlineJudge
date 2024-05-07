import java.util.*;
import java.io.*;

public class Main {
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 1;

        while (true) {
            st = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; ++i)
                graph.add(new ArrayList<>());

            visited = new boolean[n + 1];

            for (int i = 0; i < m; ++i) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int tree = 0;
            for (int i = 1; i < n + 1; ++i)
                if (!visited[i])
                    tree += check(i);

            sb.append("Case ").append(tc).append(": ");

            if (tree > 1)
                sb.append("A forest of ").append(tree).append(" trees.");
            else if (tree == 1)
                sb.append("There is one tree.");
            else
                sb.append("No trees.");
            
            sb.append("\n");

            ++tc;
        }
        System.out.println(sb);

    }

    private static int check(int root) {
        Queue<Integer> q = new LinkedList<>();
        int node = 0;
        int edge = 0;

        q.add(root);

        while (!q.isEmpty()) {
            int cn = q.poll();

            if (visited[cn]) continue;
            visited[cn] = true;
            ++node;

            for (int i = 0; i < graph.get(cn).size(); ++i) {
                int nn = graph.get(cn).get(i);
                ++edge;
                if (!visited[nn])
                    q.add(nn);

            }
        }

        return (edge / 2) + 1 == node ? 1 : 0;
    }
}