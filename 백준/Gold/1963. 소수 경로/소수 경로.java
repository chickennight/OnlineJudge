import java.util.*;
import java.io.*;

public class Main {

    private static boolean[] arr = new boolean[10000];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[10000];
        prime[0] = prime[1] = true;
        for (int i = 2; i < 10000; ++i) {
            if (!prime[i]) {
                for (int j = i + i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            int[] count = new int[10000];

            q.add(a);
            visited[a] = true;

            while (!q.isEmpty()) {
                int num = q.poll();
                for (int i = 0; i < 4; ++i) {
                    for (int j = 0; j <= 9; ++j) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int k = change(num, i, j);
                        if (!prime[k] && !visited[k]) {
                            q.add(k);
                            visited[k] = true;
                            count[k] = count[num] + 1;
                        }
                    }
                }
            }
            sb.append(count[b]).append('\n');
        }
        System.out.println(sb);
    }

    public static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char) (j + '0'));
        return Integer.parseInt(sb.toString());

    }
}