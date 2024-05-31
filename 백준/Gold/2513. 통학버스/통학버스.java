import java.util.*;
import java.io.*;

public class Main {
    static int n, k, s;

    static class Location implements Comparable<Location> {
        int locate;
        int student;

        public Location(int locate, int student) {
            this.locate = locate;
            this.student = student;
        }


        @Override
        public int compareTo(Location o) {
            return o.locate - this.locate;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        PriorityQueue<Location> leftSide = new PriorityQueue<>();
        PriorityQueue<Location> rightSide = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());
            if (dist < s) {
                leftSide.offer(new Location(s - dist, student));
            } else {
                rightSide.offer(new Location(dist - s, student));
            }
        }

        int result = 0;
        result += busMoveTime(leftSide);
        result += busMoveTime(rightSide);
        System.out.println(result);
    }

    public static int busMoveTime(PriorityQueue<Location> stations) {
        int move = 0;
        while (!stations.isEmpty()) {
            Location now = stations.poll();
            int cnt = now.student / k;

            if (now.student % k > 0)
                cnt++;

            int rem = k * cnt - now.student;
            while (!stations.isEmpty()) {
                Location next = stations.poll();
                if (next.student <= rem) {
                    rem -= next.student;
                } else {
                    next.student -= rem;
                    stations.offer(next);
                    break;
                }
            }
            move += (2 * cnt * now.locate);
        }
        return move;
    }
}