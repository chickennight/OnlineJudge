import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int prev = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            pq.add(Integer.parseInt(in.readLine()));
        }

        int now;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            cnt++;
            now = pq.poll();
            prev = prev / 2 + now;
            sb.append(prev).append('\n');
            if (now > M && now - M > K)
                pq.add(now - M);
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}