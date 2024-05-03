import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static boolean[][] visited;
    public static final int[] dx = {-1, 1, 2};
    public static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        visited = new boolean[2][500001];

        q.offer(N);
        visited[0][N] = true;

        System.out.println(find());
    }

    public static int find() {
        if (N == K) return 0;

        int size, flag, time = 0;

        while (!q.isEmpty()) {
            size = q.size();
            time++;
            flag = time % 2;

            K += time;
            if (K > 500000) return -1;

            while (size-- > 0) {
                int now = q.poll();

                int nx;
                for (int i = 0; i < 3; ++i) {
                    if (i == 2)
                        nx = now * dx[i];
                    else
                        nx = now + dx[i];

                    if (nx < 0 || nx > 500000 || visited[flag][nx]) continue;

                    q.offer(nx);
                    visited[flag][nx] = true;
                }
            }

            if (visited[flag][K]) return time;
        }

        return -1;
    }
}