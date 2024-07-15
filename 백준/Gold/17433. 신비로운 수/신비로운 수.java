import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int[] numbers = new int[N];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; ++i) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            if (N == 1) {
                sb.append("INFINITY").append('\n');
                continue;
            }

            int gcd = Math.abs(numbers[1] - numbers[0]);
            for (int i = 2; i < N; ++i) {
                gcd = GCD(gcd, Math.abs(numbers[i] - numbers[0]));
            }

            if (gcd == 0) {
                sb.append("INFINITY").append('\n');
            } else {
                sb.append(gcd).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}