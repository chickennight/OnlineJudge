import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        Map<String, List<String>> relation = new HashMap<>();
        Map<String, PriorityQueue<String>> children = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        String[] input = in.readLine().split(" ");
        for (String name : input) {
            relation.put(name, new ArrayList<>());
            children.put(name, new PriorityQueue<>());
            indegree.put(name, 0);
        }

        int M = Integer.parseInt(in.readLine());

        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            relation.get(parent).add(child);
            indegree.put(child, indegree.get(child) + 1);
        }

        StringBuilder sb = new StringBuilder();

        Queue<String> q = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int K = 0;
        for (String name : indegree.keySet()) {
            if (indegree.get(name) == 0) {
                K++;
                pq.offer(name);
                q.offer(name);
            }
        }
        sb.append(K).append("\n");

        while (!pq.isEmpty())
            sb.append(pq.poll()).append(" ");

        sb.append("\n");

        while (!q.isEmpty()) {
            String parent = q.poll();
            List<String> tempChildren = relation.get(parent);
            for (String child : tempChildren) {
                int n = indegree.get(child);
                if (n == 1) {
                    children.get(parent).add(child);
                    q.offer(child);
                }
                indegree.put(child, n - 1);
            }
        }

        for (String parent : children.keySet()) {
            StringBuilder temp = new StringBuilder();
            PriorityQueue<String> tempChildren = children.get(parent);
            temp.append(parent).append(" ").append(tempChildren.size()).append(" ");

            while (!tempChildren.isEmpty())
                temp.append(tempChildren.poll()).append(" ");

            pq.offer(temp.toString());
        }

        while (!pq.isEmpty())
            sb.append(pq.poll()).append("\n");

        System.out.println(sb);
    }
}