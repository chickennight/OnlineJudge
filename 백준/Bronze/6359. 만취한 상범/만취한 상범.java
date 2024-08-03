import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        int N;
        while (T-- > 0) {
            N = Integer.parseInt(in.readLine());
            int[] arr = new int[N + 1];
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; i * j <= N; ++j) {
                    if (arr[i * j] != 0) arr[i * j] = 0;
                    else arr[i * j] = 1;
                }
            }
            int ans = 0;
            for (int num : arr)
                ans += num;

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}