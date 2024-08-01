import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String S = in.readLine();

        int[] arr = new int[10];
        long total = 0;
        int num;
        for (int i = 0; i < S.length(); ++i) {
            num = S.charAt(i) - '0';
            arr[num] += 1;
            total += num;
        }

        if (!S.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            while (arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}