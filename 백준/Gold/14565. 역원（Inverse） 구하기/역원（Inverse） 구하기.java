import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        long B = N - A;
        sb.append(B).append(" ");

        if (GCD(A, N) != 1) {
            sb.append("-1");
        } else {
            long[] result = calculate(A, N);

            while (result[0] < 0) {
                result[0] += N;
            }

            sb.append(result[0]);
        }

        System.out.print(sb);
    }

    public static long[] calculate(long a, long b) {
        long[] result = new long[2];

        if (b == 0) {
            result[0] = 1;
            return result;
        }

        long q = a / b;
        long[] prev = calculate(b, a % b);
        result[0] = prev[1];
        result[1] = prev[0] - prev[1] * q;

        return result;
    }

    public static long GCD(long a, long b) {
        long big = Math.max(a, b);
        long small = Math.min(a, b);
        long result;

        while (true) {
            result = big % small;

            if (result == 0) {
                return small;
            }

            big = small;
            small = result;
        }
    }
}