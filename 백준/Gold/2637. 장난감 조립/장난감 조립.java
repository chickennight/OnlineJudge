import java.util.*;
import java.io.*;

public class Main {

    public static class Node {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static int[] indegree;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i)
            list[i] = new ArrayList<>();

        int[] part = new int[n + 1];
        indegree = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y, k));
            part[x]++;
            indegree[y]++;
        }

        int[] result = topologySort(n);
        for (int i = 1; i <= n; ++i)
            if (part[i] == 0)
                System.out.println(i + " " + result[i]);
    }

    public static int[] topologySort(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 1));
        int[] counter = new int[n + 1];
        counter[n] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : list[now.num]) {
                counter[next.num] += counter[now.num] * next.count;
                indegree[next.num]--;
                if (indegree[next.num] == 0)
                    q.offer(new Node(next.num, counter[next.num]));
            }
        }
        return counter;
    }

}
