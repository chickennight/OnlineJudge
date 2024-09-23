import java.io.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        nums = new int[10];
        arr = new int[N];
        String s = in.readLine();
        for (int i = 0; i < N; ++i)
            arr[i] = s.charAt(i << 1) - '0';

        System.out.println(twoPointer(0, 0, 0, 0, 0));
    }

    private static int twoPointer(int l, int r, int cnt, int kind, int max) {
        if (r >= N)
            return max;

        if (nums[arr[r]] == 0)
            kind++;

        cnt++;
        nums[arr[r]]++;

        if (kind > 2) {
            if (--nums[arr[l]] == 0)
                kind--;
            cnt--;
            l++;
        }

        max = Math.max(max, cnt);

        return twoPointer(l, r + 1, cnt, kind, max);
    }

}