import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int s = 0, e = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum >= m) {
                sum -= arr[s++];
            } else if (e == n) break;
            else {
                sum += arr[e++];
            }

            if (sum == m)
                cnt++;

        }
        System.out.println(cnt);
    }
}