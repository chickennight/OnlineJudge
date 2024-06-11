import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] A = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(A);

        if (A[0] >= 0) {
            System.out.println(A[0] + " " + A[1] + " " + A[2]);
            return;
        }

        if (A[N - 1] <= 0) {
            System.out.println(A[N - 3] + " " + A[N - 2] + " " + A[N - 1]);
            return;
        }

        long s = Long.MAX_VALUE;
        int[] ans = new int[3];
        for (int i = 0; i < N - 1; ++i) {
            int a = A[i];
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int b = A[start];
                int c = A[end];
                long sum = (long) a + b + c;
                if (Math.abs(sum) < s) {
                    s = Math.abs(sum);
                    ans[0] = a;
                    ans[1] = b;
                    ans[2] = c;
                }
                if (sum == 0) {
                    System.out.println(a + " " + b + " " + c);
                    return;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}