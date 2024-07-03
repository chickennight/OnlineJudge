import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(in.readLine());
        int P = Integer.parseInt(in.readLine());

        parent = new int[G + 1];
        for (int i = 0; i <= G; ++i)
            parent[i] = i;

        int idx = 0;

        for (idx = 0; idx < P; ++idx) {
            int now = Integer.parseInt(in.readLine());
            int gate = find(now);
            if (gate == 0)
                break;
            union(gate - 1, gate);
        }

        System.out.println(idx);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}