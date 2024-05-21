import java.util.*;
import java.io.*;

public class Main {
    static int N, K, max;
    static boolean[] visited;
    static String[] word;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        word = new String[N];
        for (int i = 0; i < N; ++i) {
            String str = in.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }

        if (K < 5) {
            System.out.println("0");
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        max = Integer.MIN_VALUE;
        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int idx, int len) {
        if (len == K - 5) {
            int count = 0;
            for (int i = 0; i < N; ++i) {
                boolean read = true;
                for (int j = 0; j < word[i].length(); ++j) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = idx; i < 26; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
    }
}