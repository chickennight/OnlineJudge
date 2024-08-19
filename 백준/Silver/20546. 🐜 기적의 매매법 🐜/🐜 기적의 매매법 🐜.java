import java.util.*;
import java.io.*;

public class Main {
    static class stock {
        int money = 0;
        int cnt = 0;

        public stock(int money, int cnt) {
            this.money = money;
            this.cnt = cnt;
        }

        public void buyStock(int cnt, int cost) {
            if (this.money < cost * cnt) return;
            money -= cost * cnt;
            this.cnt += cnt;
        }

        public void sell(int cost) {
            this.money += this.cnt * cost;
            this.cnt = 0;
        }
    }

    static int n;
    static int[] price = new int[14];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        int bnp, timing;

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 14; ++i)
            price[i] = Integer.parseInt(st.nextToken());

        bnp = BNP();
        timing = Timing();

        if (bnp < timing)
            System.out.println("TIMING");
        else if (timing < bnp)
            System.out.println("BNP");
        else
            System.out.println("SAMESAME");
    }

    public static int BNP() {
        stock s = new stock(n, 0);

        for (int i = 0; i < 14; ++i) {
            if (price[i] <= s.money)
                s.buyStock(s.money / price[i], price[i]);
        }

        return (s.cnt * price[13]) + s.money;
    }

    public static int Timing() {
        stock s = new stock(n, 0);

        for (int i = 3; i < 14; ++i) {
            if (price[i - 1] < price[i - 2] && price[i - 2] < price[i - 3])
                s.buyStock(s.money / price[i], price[i]);

            else if (price[i - 1] > price[i - 2] && price[i - 2] > price[i - 3])
                s.sell(price[i]);

        }

        return (s.cnt * price[13]) + s.money;
    }

}