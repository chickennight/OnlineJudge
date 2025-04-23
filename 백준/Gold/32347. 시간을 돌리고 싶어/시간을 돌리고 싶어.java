// 32347 시간을 돌리고 싶어

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[N + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; ++i) {
            int temp = Integer.parseInt(st.nextToken());
            v[i] = temp == 1;
        }

        int l = 0, h = N;
        while (l + 1 < h) {
            int mid = (l + h) / 2;
            if (!check(mid, N, K, v)) {
                l = mid;
            } else {
                h = mid;
            }
        }

        System.out.println(h);
    }

    static boolean check(int m, int n, int k, boolean[] v) {
        int x = n;
        for (int i = 0; i < k; ++i) {

            if (x - m <= 1)
                return true;

            int nx = x - m;

            while (nx > 0 && !v[nx])
                nx++;

            if (nx == x)
                return false;

            x = nx;
        }
        return false;
    }
}