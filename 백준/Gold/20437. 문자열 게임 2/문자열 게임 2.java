//20437 문자열 게임2

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            String W = in.readLine();
            int k = Integer.parseInt(in.readLine());

            if (k == 1) {
                sb.append("1 1").append('\n');
                continue;
            }

            int len = W.length();
            int[] alpha = new int[26];
            for (int i = 0; i < len; ++i)
                alpha[W.charAt(i) - 'a']++;

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < len; ++i) {
                if (alpha[W.charAt(i) - 'a'] < k) continue;

                int cnt = 1;
                for (int l = i + 1; l < len; ++l) {
                    if (W.charAt(i) == W.charAt(l))
                        ++cnt;

                    if (cnt == k) {
                        min = Math.min(min, l - i + 1);
                        max = Math.max(max, l - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) sb.append("-1").append('\n');
            else sb.append(min).append(" ").append(max).append('\n');
        }

        System.out.println(sb);
    }
}
