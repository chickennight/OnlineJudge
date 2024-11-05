import java.util.*;
import java.io.*;

public class Main {
    private static int a, t, n, zeroCount, oneCount, repeat = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(in.readLine());
        t = Integer.parseInt(in.readLine());
        n = Integer.parseInt(in.readLine());
        int result = solve();
        System.out.println(result);
    }

    private static int solve() {
        while (true) {
            for (int i = 0; i < 4; ++i) {
                if (i % 2 == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (n == 0 && zeroCount == t) {
                    return (zeroCount + oneCount - 1) % a;
                }
                if (n == 1 && oneCount == t) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            for (int i = 0; i < repeat; ++i) {
                zeroCount++;
                if (zeroCount == t && n == 0) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            for (int i = 0; i < repeat; ++i) {
                oneCount++;
                if (oneCount == t && n == 1) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            repeat++;
        }
    }
}