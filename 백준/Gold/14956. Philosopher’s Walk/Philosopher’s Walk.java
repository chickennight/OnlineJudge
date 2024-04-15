import java.util.*;
import java.io.*;

public class Main {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Point p = recursion(N, M, 1, 1, 0);

        System.out.println(p.y + " " + p.x);

    }

    private static Point recursion(int n, int m, int r, int c, int d) {
        if (n == 1) return new Point(r, c);

        n = n >> 1;
        int area = n * n;

        if (d == 0) {
            if (1 <= m && m <= area) return recursion(n, m, r, c, 1);
            if (area < m && m <= 2 * area) return recursion(n, m - area, r + n, c, 0);
            if (2 * area < m && m <= 3 * area) return recursion(n, m - 2 * area, r + n, c + n, 0);
            return recursion(n, m - 3 * area, r + n - 1, c + 2 * n - 1, 3);
        }

        if (d == 1) {
            if (1 <= m && m <= area) return recursion(n, m, r, c, 0);
            if (area < m && m <= 2 * area) return recursion(n, m - area, r, c + n, 1);
            if (2 * area < m && m <= 3 * area) return recursion(n, m - 2 * area, r + n, c + n, 1);
            return recursion(n, m - 3 * area, r + 2 * n - 1, c + n - 1, 2);
        }

        if (d == 2) {
            if (1 <= m && m <= area) return recursion(n, m, r, c, 3);
            if (area < m && m <= 2 * area) return recursion(n, m - area, r - n, c, 2);
            if (2 * area < m && m <= 3 * area) return recursion(n, m - 2 * area, r - n, c - n, 2);
            return recursion(n, m - 3 * area, r - n + 1, c - 2 * n + 1, 1);
        }

        if (1 <= m && m <= area) return recursion(n, m, r, c, 2);
        if (area < m && m <= 2 * area) return recursion(n, m - area, r, c - n, 3);
        if (2 * area < m && m <= 3 * area) return recursion(n, m - 2 * area, r - n, c - n, 3);
        return recursion(n, m - 3 * area, r - 2 * n + 1, c - n + 1, 0);
    }

}