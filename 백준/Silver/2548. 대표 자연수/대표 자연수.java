import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] cnt = new int[10001];
        for (int i = 0; i < n; ++i)
            cnt[Integer.parseInt(st.nextToken())]++;

        int tmp = 0;
        int mid = (n - 1) / 2;

        for (int i = 1; i <= 10000; ++i) {
            tmp += cnt[i];
            if (tmp > mid) {
                System.out.println(i);
                return;
            }
        }
        
    }

}