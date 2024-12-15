import java.io.*;
import java.util.*;

public class Main {

    private static long n;
    private static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Long.parseLong(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if (k == 1) {
                sb.append(Math.abs(x - y)).append("\n");
            } else {
                sb.append(LCA(x, y)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long LCA(long x, long y) {
        long length = 0;
        long xDepth = getDepth(x);
        long yDepth = getDepth(y);

        if (xDepth < yDepth) {
            long tmp = x;
            x = y;
            y = tmp;
            long ttmp = xDepth;
            xDepth = yDepth;
            yDepth = ttmp;
        }

        while (xDepth != yDepth) {
            x = getParent(x);
            xDepth = getDepth(x);
            length++;
        }

        while (x != y) {
            x = getParent(x);
            y = getParent(y);
            length += 2;
        }
        return length;
    }

    private static long getParent(long idx) {
        return (idx - 2) / k + 1;
    }

    private static long getDepth(long idx) {
        if (idx == 1) return 0;

        long line = 1;
        long h = 1;
        do {
            line += (long) Math.pow(k, h++);
        } while (idx > line);
        return h - 1;
    }
}