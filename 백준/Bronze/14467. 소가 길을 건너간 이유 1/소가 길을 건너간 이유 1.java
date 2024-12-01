import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[11][1];
        int cow_sum = 0;

        for (int i = 1; i < 11; ++i) {
            arr[i][0] = -1;
        }

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (arr[a][0] == -1) {
                arr[a][0] = b;
            } else {
                if (arr[a][0] != b) {
                    cow_sum++;
                    arr[a][0] = b;
                }
            }
        }

        System.out.println(cow_sum);

    }

}
