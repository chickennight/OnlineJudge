import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] titlePower = new int[N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            title[i] = st.nextToken();
            titlePower[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; ++i) {
            int num = Integer.parseInt(in.readLine());

            int start = 0;
            int last = N - 1;

            while (start <= last) {
                int mid = (start + last) / 2;

                if (titlePower[mid] < num) {
                    start = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
            sb.append(title[start]).append("\n");
        }
        System.out.println(sb);
    }
}