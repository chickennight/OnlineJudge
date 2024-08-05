import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < 3; t++) {

            boolean[] d = new boolean[50001];
            Deque<int[]> coins = new LinkedList<>();
            d[0] = true;
            int sum = 0;
            int N = Integer.parseInt(in.readLine());

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(in.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                sum += num * coin;
                for (int k = coin; k <= num * coin && k <= 50000; k += coin) {
                    d[k] = true;
                }
                coins.offer(new int[]{coin, num, sum});
            }

            if (sum % 2 == 1) sb.append(0).append('\n');
            else if (d[sum / 2]) sb.append(1).append('\n');
            else {
                while (!coins.isEmpty()) {
                    int[] now = coins.poll();
                    if (now[2] > 50000) now[2] = 50000;
                    for (int i = 0; i < now[1]; ++i) {
                        for (int j = now[2]; j > now[0]; --j) {
                            if ((j - now[0]) % now[0] == 0 && (j - now[0]) <= now[0] * now[1]) continue;
                            d[j] |= d[j - now[0]];
                        }
                    }
                }
                if (sum % 2 == 0 && d[sum / 2]) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
