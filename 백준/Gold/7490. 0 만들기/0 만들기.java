import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<String> ans;
    static String[] operator = {"+", "-", " "};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(in.readLine());
            ans = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(ans);
            for (String s : ans) {
                sb.append(s).append('\n');
            }
            sb.append('\n');

        }

        System.out.println(sb);

    }

    private static void dfs(int num, String s) {
        if (num == N) {
            String input = s.replaceAll(" ", "");
            if (cal(input))
                ans.add(s);
            return;
        }

        for (int i = 0; i < 3; ++i) {
            dfs(num + 1, s + operator[i] + (num + 1));
        }
    }


    private static boolean cal(String input) {
        StringTokenizer st = new StringTokenizer(input, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreElements()) {
            String s = st.nextToken();
            if (s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        return sum == 0;
    }
}