import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());

        int steps = calculate(n);

        System.out.println(steps);
    }

    public static int calculate(long n) {
        int steps = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n += 1;
            }
            steps++;
        }

        return steps;
    }

}
