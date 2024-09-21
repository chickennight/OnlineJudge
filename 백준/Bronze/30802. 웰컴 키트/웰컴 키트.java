import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] a = new int[6];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 6; ++i)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < 6; ++i) {
            cnt += a[i] / T;

            if (a[i] % T != 0) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
        System.out.println(N / P + " " + N % P);
    }
}