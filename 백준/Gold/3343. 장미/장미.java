import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        long N = Long.parseLong(st.nextToken());
        long amountA = Long.parseLong(st.nextToken());
        long priceA = Long.parseLong(st.nextToken());
        long amountB = Long.parseLong(st.nextToken());
        long priceB = Long.parseLong(st.nextToken());

        if (priceA * amountB < priceB * amountA) {
            long tempPrice = priceA;
            priceA = priceB;
            priceB = tempPrice;
            long tempAmount = amountA;
            amountA = amountB;
            amountB = tempAmount;
        }

        long ans = Long.MAX_VALUE;

        for (int a = 0; a < amountB; ++a) {
            long b = (long) Math.ceil((double) (N - a * amountA) / amountB);
            boolean tf = false;
            if (b < 0) {
                b = 0;
                tf = true;
            }

            ans = Math.min(ans, a * priceA + b * priceB);
            if (tf)
                break;
        }
        System.out.println(ans);
    }

}