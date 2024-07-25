import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        int N, max, min, n;
        StringTokenizer st;
        while (T-- > 0) {
            max = -1000001;
            min = 1000001;
            N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; ++i) {
                n = Integer.parseInt(st.nextToken());
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
            sb.append(min).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }
}