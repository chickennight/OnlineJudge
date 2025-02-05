//19941 햄버거 분배

import java.io.*;
import java.util.*;

public class Main {
    private static char[] table;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        table = in.readLine().toCharArray();
        ans = 0;

        for (int i = 0; i < N; ++i) {
            if (table[i] == 'P') {
                int idx = Math.max(i - K, 0);
                boolean tf = false;
                for (int j = idx; j < i; ++j) {
                    if (burger(j)) {
                        tf = true;
                        break;
                    }
                }

                if (!tf) {
                    idx = i + K >= N ? N - 1 : i + K;
                    for (int j = i + 1; j <= idx; ++j) {
                        if (burger(j))
                            break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean burger(int idx) {
        if (table[idx] == 'H') {
            table[idx] = 0;
            ++ans;
            return true;
        }
        return false;
    }
}