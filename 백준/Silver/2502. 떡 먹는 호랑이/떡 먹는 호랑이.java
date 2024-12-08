import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (D == 3)
            System.out.println(1 + "\n" + (K - 1));
        else {
            int x = 1, y = 1;
            for (int i = 4; i <= D; ++i) {
                int temp = y;
                y = x + y;
                x = temp;
            }
            int size = K / y;
            for (int i = size - 1; i >= 0; --i) {
                if ((K - (i * y)) % x == 0) {
                    System.out.println((K - (i * y)) / x + "\n" + i);
                    break;
                }
            }
        }
    }

}