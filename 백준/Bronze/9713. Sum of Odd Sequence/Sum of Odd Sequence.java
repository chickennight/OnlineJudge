import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int ans = 0;
            for (int i = 1; i <= N; i += 2)
                ans += i;

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

}