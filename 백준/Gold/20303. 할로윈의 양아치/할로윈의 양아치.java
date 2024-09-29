import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int cost;
        int value;

        public Node(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] candy = new int[N + 1];
        int[] count = new int[N + 1];
        parent = new int[N + 1];

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; ++i) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            count[i] = 1;
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i <= N; ++i) {
            if (parent[i] != i) {
                int temp = find(i);
                candy[temp] += candy[i];
                count[temp] += count[i];
            }
        }
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            if (parent[i] == i) {
                list.add(new Node(count[i], candy[i]));
            }

        }
        int[][] dp = new int[list.size() + 1][K];
        for (int i = 1; i <= list.size(); ++i) {
            for (int j = 0; j < K; ++j) {
                if (list.get(i - 1).cost <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i - 1).cost] + list.get(i - 1).value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        System.out.println(dp[list.size()][K - 1]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}