import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];


        Arrays.fill(parent, -1);

        int cnt = 0;
        while (M-- > 0) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int a = find(u);
            int b = find(v);

            if (a == b) {
                cnt++;
                continue;
            }

            union(a, b);
        }

        int group = 0;
        for (int i = 1; i < parent.length; ++i) {
            if (parent[i] < 0)
                group++;
        }

        System.out.print(cnt + group - 1);
    }

    static void union(int a, int b) {
        if (parent[a] < parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    static int find(int u) {
        if (parent[u] < 0)
            return u;
        return parent[u] = find(parent[u]);
    }

}