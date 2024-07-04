import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L, K;
    static List<int[]> stars;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        int max = Integer.MIN_VALUE;
        for (int[] s1 : stars) {
            for (int[] s2 : stars) {
                max = Math.max(max, boundStar(s1[0], s2[1]));
            }
        }
        System.out.println(K - max);
    }

    private static int boundStar(int x, int y) {
        int result = 0;
        for (int[] s : stars) {
            if (x <= s[0] && s[0] <= x + L && y <= s[1] && s[1] <= y + L) result++;
        }
        return result;
    }
}