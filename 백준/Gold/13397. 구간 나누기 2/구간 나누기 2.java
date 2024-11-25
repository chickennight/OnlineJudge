import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static final int MAX = 987654321;
    ;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int right = Integer.MIN_VALUE;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }

        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;
            if (solve(mid) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static int solve(int mid) {
        int result = 1;
        int min = MAX;
        int max = -MAX;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                result++;
                max = -MAX;
                min = MAX;
                i--;
            }
        }
        return result;
    }

}