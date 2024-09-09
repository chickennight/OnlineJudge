import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] count = new int[1000001];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = -1, min = 1000001;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            count[l]++;
            count[r]--;
            min = Math.min(min, l);
            max = Math.max(max, r);
        }

        for (int i = min + 1; i <= max; ++i)
            count[i] += count[i - 1];

        int start = min, end = min;
        int A = 0, B = 0;
        int s = 0;
        while (end <= max) {
            if (s < K) {
                s += count[end++];
            } else if (s == K) {
                A = start;
                B = end;
                break;
            } else
                s -= count[start++];
        }
        if (A == min)
            A = 0;
        System.out.println(A + " " + B);
    }
}