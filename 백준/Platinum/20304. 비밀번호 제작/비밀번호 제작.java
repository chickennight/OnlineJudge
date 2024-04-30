import javax.sound.midi.Soundbank;
import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] safe;
    private static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        safe = new int[1000001];
        Arrays.fill(safe, Integer.MIN_VALUE);

        q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        while (M-- > 0) {
            int p = Integer.parseInt(st.nextToken());
            q.offer(p);
            safe[p] = 0;
        }

        System.out.println(findSafe());
    }

    public static int findSafe() {
        int max = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 20; ++i) {
                int nx = now ^ (1 << i);

                if (nx > N || safe[nx] != Integer.MIN_VALUE) continue;

                q.offer(nx);
                safe[nx] = safe[now] + 1;
                max = Math.max(max, safe[nx]);
            }
        }

        return max;
    }

}