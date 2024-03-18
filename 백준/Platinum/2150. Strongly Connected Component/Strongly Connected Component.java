import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Integer>> graph, RGraph, SCC;
    static boolean[] visit;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        RGraph = new ArrayList<>();
        SCC = new ArrayList<>();
        stack = new Stack<>();
        visit = new boolean[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
            RGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            RGraph.get(end).add(start);
        }

        for (int i = 1; i <= V; i++) {
            if (!visit[i]) {
                DFS(i);
            }
        }

        Arrays.fill(visit, false);

        int sccNum = 0;
        SCC.add(new ArrayList<>());
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visit[node]) {
                RDFS(node, sccNum);
                sccNum++;
                SCC.add(new ArrayList<>());
            }
        }
        SCC.remove(SCC.size() - 1);

        for (List<Integer> s : SCC) {
            Collections.sort(s);
        }

        SCC.sort(Comparator.comparingInt(o -> o.get(0)));

        StringBuilder sb = new StringBuilder();
        sb.append(SCC.size());
        sb.append('\n');
        for (List<Integer> s : SCC) {
            for (int i : s) {
                sb.append(i).append(" ");
            }
            sb.append(-1);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void RDFS(int node, int sccNum) {
        visit[node] = true;

        SCC.get(sccNum).add(node);

        for (int i : RGraph.get(node)) {
            if (!visit[i]) {
                RDFS(i, sccNum);
            }
        }
    }

    private static void DFS(int node) {
        visit[node] = true;

        for (int i : graph.get(node)) {
            if (!visit[i]) {
                DFS(i);
            }
        }
        stack.push(node);
    }
}