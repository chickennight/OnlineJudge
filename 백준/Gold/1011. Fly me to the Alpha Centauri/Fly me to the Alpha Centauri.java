import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());
        StringTokenizer st;
        for (int i = 0; i < tc; ++i) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = end - start;
            int sqrtDist = (int) Math.sqrt(distance);

            if (distance == sqrtDist * sqrtDist) {
                sb.append(2 * sqrtDist - 1).append("\n");
            } else if (distance <= sqrtDist * sqrtDist + sqrtDist) {
                sb.append(2 * sqrtDist).append("\n");
            } else {
                sb.append(2 * sqrtDist + 1).append("\n");
            }
        }
        System.out.println(sb);

    }
}