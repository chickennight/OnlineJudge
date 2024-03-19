import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[Integer.parseInt(st.nextToken())] = i;

        int max = 1;
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (arr[i] > arr[i - 1]) {
                if (++cnt > max) max = cnt;
            } else {
                cnt = 1;
            }
        }
        System.out.println(n - max);
    }

}