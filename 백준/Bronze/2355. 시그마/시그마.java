import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        if (b > a) {
            long c = b;
            b = a;
            a = c;
        }
        long answer = (a + b) * (a - b + 1) / 2;
        System.out.println(answer);
    }
}