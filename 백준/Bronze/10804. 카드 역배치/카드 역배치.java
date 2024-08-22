import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] card = new int[21];
        for (int i = 0; i < card.length; ++i) {
            card[i] = i;
        }
        for (int i = 0; i < 10; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = 0;
            for (int j = 0; j < (b - a + 1) / 2; ++j) {
                temp = card[a + j];
                card[a + j] = card[b - j];
                card[b - j] = temp;
            }
        }
        in.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < card.length; ++i) {
            sb.append(card[i] + " ");
        }
        System.out.println(sb);
    }
}