import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(in.readLine());
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max;

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < N; ++i) {
                cnt += (int) (arr[i] / mid);
            }
            if (cnt >= K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

}