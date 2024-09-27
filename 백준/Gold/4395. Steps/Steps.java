import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(minSteps(x, y)).append('\n');
        }

        System.out.println(sb);
    }

    public static int minSteps(int x, int y) {
        int distance = y - x;
        int step = 0;
        int move = 1;
        int totalMove = 0;

        while (totalMove < distance) {
            step++;
            totalMove += move;
            if (step % 2 == 0) {
                move++;
            }
        }
        return step;
    }

}