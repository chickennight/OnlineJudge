import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[H + 2];
        int[] up = new int[H + 2];

        for (int i = 0; i < N / 2; ++i) {
            int d = Integer.parseInt(in.readLine());
            int u = H - Integer.parseInt(in.readLine()) + 1;
            down[d]++;
            up[u]++;
        }

        for (int i = 1; i <= H; ++i)
            down[i] += down[i - 1];
        for (int i = H; i >= 1; --i)
            up[i] += up[i + 1];

        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 1; i <= H; ++i) {
            int d = down[H] - down[i - 1];
            int u = up[1] - up[i + 1];

            if (min > d + u) {
                min = d + u;
                num = 1;
            } else if (min == d + u) num++;
        }

        System.out.println(min + " " + num);
    }

}