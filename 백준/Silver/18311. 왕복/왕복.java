import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        boolean reverse = false;

        int[] course = new int[N + 1];

        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; ++i) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; ++i) {
            K -= course[i];
            if (K < 0) {
                System.out.println(i + 1);
                reverse = true;
                break;
            }
        }

        if (!reverse) {
            for (int i = N - 1; i >= 0; --i) {
                K -= course[i];
                if (K < 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }

}