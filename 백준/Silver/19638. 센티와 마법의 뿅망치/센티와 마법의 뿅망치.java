// 19638 센티와 마법의 뿅망치

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0)
            pq.add(Integer.parseInt(in.readLine()));

        int cnt = 0;
        while (T-- > 0) {
            if ((pq.peek() < H) || (pq.peek() == 1)) break;
            cnt++;
            pq.add(pq.poll() / 2);
        }

        if (pq.peek() < H) {
            System.out.println("YES");
            System.out.println(cnt);
        } else {
            System.out.println("NO");
            System.out.println(pq.poll());
        }
    }
}