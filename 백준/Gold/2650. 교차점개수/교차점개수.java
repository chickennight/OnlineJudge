import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        n /= 2;
        int[] to = {0, 0, 2, 3, 1};
        List<int[]> p = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            a = to[a];
            c = to[c];
            int x = a * 51 + b, y = c * 51 + d;
            if (a > 1) x += 51 - 2 * b;
            if (c > 1) y += 51 - 2 * d;

            p.add(new int[]{Math.min(x, y), Math.max(x, y)});
        }

        int ans = 0;
        int[] cross = new int[n];
        for (int i = 0; i < n; ++i) {
            int[] current = p.get(i);
            for (int j = 0; j < n; ++j) {
                int[] next = p.get(j);
                if (current[0] < next[0] && next[0] < current[1] && current[1] < next[1]) {
                    ans++;
                    cross[i]++;
                    cross[j]++;
                }
            }
        }

        System.out.println(ans);
        System.out.println(Arrays.stream(cross).max().getAsInt());
    }
}
