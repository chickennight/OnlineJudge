import java.util.*;
import java.io.*;

public class Main {
    private static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower f) {
            if (this.start == f.start)
                return f.end - this.end;
            return this.start - f.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;
        Flower[] flowers = new Flower[N];

        int startMonth, startDay, endMonth, endDay;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            startMonth = Integer.parseInt(st.nextToken());
            startDay = Integer.parseInt(st.nextToken());
            endMonth = Integer.parseInt(st.nextToken());
            endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        Arrays.parallelSort(flowers);

        int end = 1201;
        int start = 301;
        int count = 0;
        int max = 0;
        int index = 0;

        while (start < end) {
            boolean tf = false;

            for (int i = index; i < N; ++i) {
                if (flowers[i].start > start)
                    break;

                if (max < flowers[i].end) {
                    tf = true;
                    max = flowers[i].end;
                    index = i + 1;
                }
            }

            if (tf) {
                start = max;
                count++;
            } else {
                break;
            }
        }

        if (max < end)
            System.out.println(0);
        else
            System.out.println(count);
    }

}