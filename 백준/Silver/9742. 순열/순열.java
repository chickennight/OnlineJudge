import java.util.*;
import java.io.*;

public class Main {
    private static int totalCount, num;
    private static boolean[] visit;
    private static char[] chars;
    private static String answer;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            num = Integer.parseInt(st.nextToken());


            totalCount = 0;
            chars = new char[s.length()];
            visit = new boolean[s.length()];

            dfs(s, 0);

            if (totalCount < num) answer = "No permutation";
            System.out.println(s + " " + num + " = " + answer);
        }
    }

    private static void dfs(String s, int cnt) {
        if (cnt == s.length()) {
            totalCount++;
            if (totalCount == num) answer = new String(chars);

            return;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (!visit[i]) {
                visit[i] = true;
                chars[cnt] = s.charAt(i);
                dfs(s, cnt + 1);
                visit[i] = false;
            }
        }
    }
}