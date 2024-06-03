import java.util.*;
import java.io.*;

public class Main {

    static private class Path implements Comparable<Path> {
        int end, time;

        public Path(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Path o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());
        StringTokenizer st;
        int n, d, c, a, b, s;
        while (tc-- > 0) {
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            List<Path>[] paths = new List[n + 1];
            for (int i = 1; i < n + 1; ++i)
                paths[i] = new ArrayList<>();

            while (d-- > 0) {
                st = new StringTokenizer(in.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                paths[b].add(new Path(a, s));
            }

            int[] time = new int[n + 1];
            Arrays.fill(time, Integer.MAX_VALUE);
            int max = 0;
            int cnt = 0;
            PriorityQueue<Path> pq = new PriorityQueue<>();
            pq.offer(new Path(c, 0));
            time[c] = 0;
            while (!pq.isEmpty()) {
                Path now = pq.poll();
                if (now.time > time[now.end]) continue;

                for (Path next : paths[now.end]) {
                    if (time[next.end] > now.time + next.time) {
                        time[next.end] = now.time + next.time;
                        pq.offer(new Path(next.end, time[next.end]));
                    }
                }
            }

            for (int i = 1; i <= n; ++i) {
                if (time[i] != Integer.MAX_VALUE) {
                    cnt++;
                    max = Math.max(max, time[i]);
                }
            }
            sb.append(cnt).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}