import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int first = 0;
        int second = 0;

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            int M = Integer.parseInt(st.nextToken());
            if ((M % 30) >= 0) {
                first += ((M / 30) + 1) * 10;
            } else {
                first += (M / 30) * 10;
            }
            if ((M % 60) >= 0) {
                second += ((M / 60) + 1) * 15;
            } else {
                second += (M / 60) * 15;
            }
        }

        if (first < second) {
            System.out.println("Y " + first);
        } else if (second < first) {
            System.out.println("M " + second);
        } else {
            System.out.println("Y M " + first);
        }
    }
}