import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(in.readLine());

        int max = 0;
        for (int i = 0; i < N; ++i) {

            int score = 0;
            for (int j = 0; j < 3; ++j) {
                st = new StringTokenizer(in.readLine());
                score += a * Integer.parseInt(st.nextToken());
                score += b * Integer.parseInt(st.nextToken());
                score += c * Integer.parseInt(st.nextToken());
            }


            if (max < score) max = score;
        }

        System.out.print(max);
    }
}