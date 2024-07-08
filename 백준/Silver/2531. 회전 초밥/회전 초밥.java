import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] eating = new int[d + 1];
        eating[c] = 3001;
        int[] sushi = new int[N];
        int count = 1;

        for (int i = 0; i < N; ++i)
            sushi[i] = Integer.parseInt(in.readLine());

        for (int i = 0; i < k; ++i) {
            int idx = sushi[i];
            if (eating[idx] == 0)
                count++;
            eating[idx]++;
        }

        int max = count;
        for (int i = 0; i < N - 1; ++i) {
            int start = sushi[i];
            int end = sushi[i + k < N ? i + k : (i + k) % N];
            if (--eating[start] == 0)
                count--;
            if (++eating[end] == 1)
                count++;
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}