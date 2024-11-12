import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        BigInteger mul = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).multiply(BigInteger.valueOf(c));

        int[] counts = new int[10];
        char[] marr = String.valueOf(mul).toCharArray();

        for (char value : marr) {
            counts[value - '0']++;
        }

        for (int count : counts) {
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}