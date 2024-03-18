import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] tree;
    static int[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int size = 1;
        while (size < n) size <<= 1;
        size <<= 1;

        tree = new int[size];
        lazy = new int[size];

        while (m-- != 0) {
            st = new StringTokenizer(in.readLine());
            int cond = Integer.parseInt(st.nextToken());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            if (cond == 0)
                toggle(1, 0, n - 1, t1 - 1, t2 - 1);
            else
                sb.append(sum(1, 0, n - 1, t1 - 1, t2 - 1)).append('\n');
        }

        System.out.println(sb);
    }

    public static void toggle(int node, int st, int ed, int left, int right) {
        updateLazy(node, st, ed);
        if (st > right || ed < left) return;
        if (left <= st && ed <= right) {
            tree[node] = (ed - st + 1) - tree[node];

            if (st != ed) {
                lazy[node * 2] ^= 1;
                lazy[node * 2 + 1] ^= 1;
            }
            return;
        }

        toggle(node * 2, st, (st + ed) / 2, left, right);
        toggle(node * 2 + 1, (st + ed) / 2 + 1, ed, left, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static int sum(int node, int st, int ed, int left, int right) {
        updateLazy(node, st, ed);
        if (st > right || ed < left) return 0;
        if (left <= st && ed <= right) return tree[node];

        return sum(node * 2, st, (st + ed) / 2, left, right)
                + sum(node * 2 + 1, (st + ed) / 2 + 1, ed, left, right);
    }

    public static void updateLazy(int node, int st, int ed) {
        if (lazy[node] != 0) {
            tree[node] = (ed - st + 1) - tree[node];

            if (st != ed) {
                lazy[node * 2] ^= 1;
                lazy[node * 2 + 1] ^= 1;
            }
            lazy[node] = 0;
        }
    }

}