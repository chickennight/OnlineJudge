import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] price = new int[N][2];

        for (int i = 0; i < price.length; i++) {
            st = new StringTokenizer(in.readLine());
            price[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(price, (o1, o2) -> {
            if (o1[1] == o2[1])
                return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int totalPrice = -1;
        int totalWeight = 0;
        int answer = Integer.MAX_VALUE;
        boolean isPossible = false;

        for (int i = 0; i < N; ++i) {
            totalWeight += price[i][0];

            if (i > 0 && price[i - 1][1] == price[i][1])
                totalPrice += price[i][1];
            else
                totalPrice = price[i][1];

            if (totalWeight >= M) {
                isPossible = true;
                answer = Math.min(answer, totalPrice);
            }
        }

        System.out.println(isPossible ? answer : -1);
    }

}