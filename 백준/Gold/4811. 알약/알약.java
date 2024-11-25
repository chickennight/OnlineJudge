import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long[][] arr = new long[31][31];

        arr[1][0] = 1;

        for (int i = 0; i <= 30; ++i) {
            for (int j = 0; j <= 30; ++j) {
                if (i < 30) {
                    arr[i +1][j] += arr[i][j];
                }
                if (j < i) {
                    arr[i][j +1] += arr[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(in.readLine());
            if (n == 0) {
                break;
            }
            sb.append(arr[n][n]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}