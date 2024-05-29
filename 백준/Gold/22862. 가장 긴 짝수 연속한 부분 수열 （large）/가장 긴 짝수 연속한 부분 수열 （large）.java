import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num % 2 == 0;
        }

        int max = getMax(n, k, arr);

        System.out.println(max);

    }

    private static int getMax(int n, int k, boolean[] arr) {
        int max = 0;
        int l = 0;
        int r = 0;
        int cnt = 0;
        while (r < n) {
            if (cnt < k) {
                if (!arr[r])
                    cnt++;
                r++;
                max = Math.max(r - l - cnt, max);
            } else if (arr[r]) {
                r++;
                max = Math.max(r - l - cnt, max);
            } else {
                if (!arr[l])
                    cnt--;
                l++;
            }
        }
        return max;
    }
}