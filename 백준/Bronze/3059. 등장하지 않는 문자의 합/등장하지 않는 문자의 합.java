import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        int sum, idx;
        boolean[] alpha = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; ++i) {
            String s = in.readLine();
            sum = 0;
            Arrays.fill(alpha, false);

            for (int j = 0; j < s.length(); ++j) {
                idx = s.charAt(j) - 'A';
                alpha[idx] = true;
            }

            for (int j = 0; j < 26; ++j) {
                if (!alpha[j]) {
                    sum += (j + 'A');
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
