import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        long result = 0;
        long cnt = 1;

        for (int i = 0; i < n; ++i) {
            char[] arr = in.readLine().toCharArray();

            for (int j = 23; j >= 0; --j) {
                result += (arr[j] - '0') * cnt;
                cnt *= 2;
            }
            sb.append(result).append('\n');
            cnt = 1;
            result = 0;
        }
        System.out.println(sb);
    }
}