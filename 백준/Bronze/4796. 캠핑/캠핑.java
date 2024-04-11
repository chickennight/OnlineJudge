import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int L, P, V, day, num = 1;
        while (true) {
            st = new StringTokenizer(in.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;
            day = 0;
            day += V / P * L;
            day += Math.min(V % P, L);
            sb.append("Case ").append(num++).append(": ").append(day).append("\n");
        }

        System.out.println(sb);
    }
}