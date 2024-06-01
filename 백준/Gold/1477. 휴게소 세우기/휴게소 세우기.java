import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        int ans = binarySearch(L, arr, M);

        System.out.print(ans);
    }

    private static int binarySearch(int L, int[] arr, int M) {
        int l = 1;
        int r = L - 1;

        int ans = 0;

        while (l <= r) {

            int mid = (l + r) / 2;
            int cnt = countRest(mid, arr);

            if (cnt > M) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    private static int countRest(int target, int[] arr) {
        int cnt = 0;

        for (int i = 0; i <= arr.length - 2; ++i) {
            int tempDist = arr[i + 1] - arr[i];

            cnt += (tempDist) / target;

            if (tempDist % target == 0)
                cnt--;
        }

        return cnt;
    }
}