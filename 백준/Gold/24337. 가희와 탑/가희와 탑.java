import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= a - 1; ++i)
            list.add(i);

        list.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; --i)
            list.add(i);

        for (int i = 0; i < N - (a + b - 1); ++i)
            list.add(1, 1);

        for (int n : list)
            sb.append(n).append(' ');

        System.out.println(sb);
    }
}