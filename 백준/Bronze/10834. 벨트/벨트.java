import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(in.readLine());

        int belt = 0;
        int time = 1;

        for (int i = 0; i < M; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (s == 1) {
                if (belt == 0)
                    belt = 1;
                else belt = 0;
            }

            time = (time / a) * b;
        }

        System.out.println(belt + " " + time);
    }
}