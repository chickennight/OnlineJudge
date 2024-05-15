import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> problems = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        while (N-- > 0) {
            st = new StringTokenizer(in.readLine());
            problems.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<Integer> solveList = new PriorityQueue<>();

        while (!problems.isEmpty()) {
            int[] problem = problems.poll();

            if (solveList.size() < problem[0]) {
                solveList.offer(problem[1]);
            } else {
                if (solveList.peek() < problem[1]) {
                    solveList.poll();
                    solveList.offer(problem[1]);
                }
            }
        }

        int result = 0;
        for (Integer num : solveList) {
            result += num;
        }
        System.out.println(result);

    }
}