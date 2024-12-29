import java.io.*;
import java.util.*;

public class Main {
    private static final int TYPES = 8;
    private static int[] status;
    private static int[] seq;
    private static boolean[] check;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        status = new int[TYPES];
        for (int i = 0; i < TYPES; ++i) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        seq = new int[TYPES];
        check = new boolean[TYPES];
        seq[0] = status[0];
        check[0] = true;
        backtrack(1);
        System.out.println(count * TYPES);
    }

    private static void backtrack(int depth) {
        if (depth == TYPES) {
            if (isConvex(0) && isConvex(1)) {
                count++;
            }
            return;
        }
        for (int i = 1; i < TYPES; ++i) {
            if (check[i]) continue;
            seq[depth] = status[i];
            if (depth < 2 || isConvex(depth)) {
                check[i] = true;
                backtrack(depth + 1);
                check[i] = false;
            }
        }
    }

    private static boolean isConvex(int curr) {
        int before = (curr + TYPES - 2) % TYPES;
        int middle = (curr + TYPES - 1) % TYPES;
        int next = curr % TYPES;
        double line = Math.sqrt(2) * seq[before] * seq[next] / (seq[before] + seq[next]);
        return seq[middle] > line;
    }
}