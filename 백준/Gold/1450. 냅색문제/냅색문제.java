import java.io.*;
import java.util.*;

public class Main {
    private static int c;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        combination(left, 0, n / 2, 0);
        combination(right, n / 2, n, 0);
        right.sort(Comparator.comparingInt(a -> a));

        int cnt = 0;
        int idx;
        for (Integer num : left) {
            idx = binarySearch(0, right.size() - 1, num, right);
            cnt += idx + 1;
        }
        System.out.println(cnt);
    }

    private static void combination(List<Integer> list, int s, int e, int sum) {
        if (sum > c) return;
        if (s == e) {
            list.add(sum);
            return;
        }
        combination(list, s + 1, e, sum);
        combination(list, s + 1, e, sum + arr[s]);
    }

    private static int binarySearch(int l, int r, int target, List<Integer> right) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (right.get(mid) <= c - target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

}