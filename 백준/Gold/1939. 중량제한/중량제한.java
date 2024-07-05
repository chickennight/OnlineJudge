import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static List<City>[] list;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i)
            list[i] = new ArrayList<>();

        int l = 0;
        int r = 0;
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new City(b, c));
            list[b].add(new City(a, c));
            r = Math.max(r, c);
        }

        st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (l <= r) {
            int mid = (l + r) / 2;
            ans = -1;
            check = new boolean[n + 1];
            dfs(start, end, mid);
            if (ans != -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(r);
    }

    static void dfs(int pos, int target, int limit) {
        if (pos == target) {
            ans = pos;
            return;
        }

        check[pos] = true;
        for (City c : list[pos]) {
            if (!check[c.to] && limit <= c.w) {
                dfs(c.to, target, limit);
            }
        }
    }
}

class City {
    int to;
    int w;

    public City(int to, int w) {
        this.to = to;
        this.w = w;
    }
}