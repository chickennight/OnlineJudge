import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Pair>> G = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            G.add(new ArrayList<>());


        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            G.get(u).add(new Pair(v, w));
        }

        long INF = (long) 4e18;
        long MOD = 998244353;

        long[] D = new long[N + 1];
        Arrays.fill(D, INF);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.first));
        pq.add(new Pair(0, 1));
        D[1] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.second;
            if (current.first > D[u]) continue;
            for (Pair edge : G.get(u)) {
                int v = (int) edge.first;
                long w = edge.second;
                if (D[v] > D[u] + w) {
                    D[v] = D[u] + w;
                    pq.add(new Pair(D[v], v));
                }
            }
        }

        List<List<Pair>> H = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            H.add(new ArrayList<>());
        }

        for (int u = 1; u <= N; u++) {
            for (Pair edge : G.get(u)) {
                int v = (int) edge.first;
                long w = edge.second;
                if (D[v] == D[u] + w) {
                    H.get(u).add(new Pair(v, (int)w));
                }
            }
        }

        int[] ind = new int[N + 1];
        for (int u = 1; u <= N; u++) {
            for (Pair edge : H.get(u)) {
                ind[(int) edge.first]++;
            }
        }

        long[] dp = new long[N + 1];
        Arrays.fill(dp, 0);

        Queue<Integer> q = new LinkedList<>();
        if (ind[1] == 0) {
            dp[1] = 1;
            q.add(1);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Pair edge : H.get(u)) {
                int v = (int) edge.first;
                dp[v] = (dp[v] + dp[u]) % MOD;
                if (--ind[v] == 0) {
                    q.add(v);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ind[i] > 0) {
                dp[i] = -1;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(dp[i]);
        }
    }

}
