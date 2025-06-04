// 19940 피자 오븐

import java.io.*;
import java.util.*;

public class Main {

    static class Count {
        int addh, addt, mint, addo, mino, time;

        Count(int addh, int addt, int mint, int addo, int mino, int time) {
            this.addh = addh;
            this.addt = addt;
            this.mint = mint;
            this.addo = addo;
            this.mino = mino;
            this.time = time;
        }
    }

    static final int MAX = 65;
    static Count[] minute = new Count[MAX];
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        bfs();
        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int m = N / 60;
            int r = N % 60;
            Count ans = minute[r];
            System.out.println((ans.addh + m) + " " + ans.addt + " " + ans.mint + " " + ans.addo + " " + ans.mino);
        }
    }

    static void bfs() {
        Queue<Count> q = new ArrayDeque<>();
        q.offer(new Count(0, 0, 0, 0, 0, 0));

        while (!q.isEmpty()) {
            Count now = q.poll();
            int t = now.time;

            if (t < 0 || t > 60 || visited[t]) 
                continue;

            visited[t] = true;
            minute[t] = now;

            q.offer(new Count(now.addh, now.addt, now.mint, now.addo, now.mino + 1, t - 1));
            q.offer(new Count(now.addh, now.addt, now.mint, now.addo + 1, now.mino, t + 1));
            q.offer(new Count(now.addh, now.addt, now.mint + 1, now.addo, now.mino, t - 10));
            q.offer(new Count(now.addh, now.addt + 1, now.mint, now.addo, now.mino, t + 10));
            q.offer(new Count(now.addh + 1, now.addt, now.mint, now.addo, now.mino, t + 60));
        }
    }

}
