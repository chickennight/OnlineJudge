import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        for (int i = 1; i < N; ++i) {
            if (pq.peek() <= lectures[i].start)
                pq.poll();
            pq.add(lectures[i].end);
        }

        System.out.println(pq.size());
    }

}