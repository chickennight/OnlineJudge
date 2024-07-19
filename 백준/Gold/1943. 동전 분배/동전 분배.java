import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int tc = 3;
        StringTokenizer st;
        while (tc-- > 0) {
            int n = Integer.parseInt(in.readLine());
            Coin[] coins = new Coin[n + 1];
            boolean[] dp = new boolean[100001];

            int total = 0;
            for (int i = 1; i <= n; ++i) {
                st = new StringTokenizer(in.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(value, quantity);
                total += value * quantity;
                for (int j = 1; j <= quantity; j++) {
                    dp[value * j] = true;
                }
            }

            if (total % 2 == 1) {
                sb.append(0).append('\n');
                continue;
            } else if (dp[total / 2]) {
                sb.append(1).append('\n');
                continue;
            }

            dp[0] = true;
            for (int i = 1; i <= n; ++i) {
                int value = coins[i].value;
                int quantity = coins[i].quantity;

                for (int j = total / 2; j >= value; --j) {
                    if (dp[j - value]) {
                        for (int k = 1; k <= quantity; ++k) {
                            if (j - value + value * k > total / 2)
                                break;
                            dp[j - value + value * k] = true;
                        }
                    }
                }
            }
            sb.append(dp[total / 2] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }
}

class Coin {
    int value, quantity;

    public Coin(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }
}