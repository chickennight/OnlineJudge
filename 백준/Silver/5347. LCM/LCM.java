import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        StringTokenizer st;
        int a, b, gcd;
        while (n-- > 0) {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            gcd = GCD(a, b);
            sb.append((long) a * b / gcd).append("\n");
        }
        System.out.println(sb);
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
}