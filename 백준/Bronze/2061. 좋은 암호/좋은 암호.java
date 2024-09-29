import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {


    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        BigInteger K = new BigInteger(st.nextToken());
        BigInteger L = new BigInteger(st.nextToken());
        int N = 0;

        for (int i = 2; i < L.intValue(); ++i) {
            if ((K.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
                N = i;
                break;
            }
        }

        System.out.println((N > 0) ? ("BAD " + N) : "GOOD");
    }

}