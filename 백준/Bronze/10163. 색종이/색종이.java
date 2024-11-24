import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] count = new int[n + 1];
        int[][] arr = new int[1001][1001];

        StringTokenizer st;
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = x; j < (x + width); ++j) {
                for (int k = y; k < (y + height); ++k) {
                    arr[j][k] = i;
                }
            }
        }

        for (int i = 0; i < 1001; ++i) {
            for (int j = 0; j < 1001; ++j) {
                count[arr[i][j]]++;
            }
        }

        for (int i = 1; i <= n; ++i) {
            System.out.println(count[i]);
        }
    }

}