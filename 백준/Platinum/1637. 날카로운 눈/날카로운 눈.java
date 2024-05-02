import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, B, C;
    static long min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(in.readLine());

        A = new int[N];
        B = new int[N];
        C = new int[N];
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());

            min = Math.min(min, A[i]);
            max = Math.max(max, C[i]);
        }
        max++;
        binarySearch();
    }

    static void binarySearch() {
        long l = min;
        long r = max;

        while (l < r) {
            long m = (l + r) / 2;

            long sum = getSum(m);

            if (sum % 2 == 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (l == max) {
            System.out.println("NOTHING");
        } else {
            long num = getSum(l) - getSum(l - 1);
            System.out.println(l + " " + num);
        }
    }

    static long getSum(long target) {
        long sum = 0;
        for (int i = 0; i < N; ++i)
            if (target >= A[i])
                sum += (Math.min(target, C[i]) - A[i]) / B[i] + 1;

        return sum;
    }
}