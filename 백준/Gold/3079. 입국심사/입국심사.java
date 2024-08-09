import java.io.*;
import java.util.*;

public class Main {

    private static long m, max, result;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        result = Long.MAX_VALUE;

        arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        binary();

        System.out.println(result);
    }

    private static void binary() {
        long l = 0;
        long r = m * max;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = 0;
            for (long idx : arr) {
                long cnt = mid / idx;

                if (sum >= m) {
                    break;
                }
                sum += cnt;
            }
            if (sum >= m) {
                r = mid - 1;
                result = Math.min(mid, result);
            } else {
                l = mid + 1;
            }
        }
    }

}
