import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 0; i < N + 1; ++i)
            parent[i] = i;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b))
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b)
                parent[b] = a;
            else
                parent[a] = b;

        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

}