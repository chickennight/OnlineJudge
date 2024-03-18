import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static Random rand = new Random();
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger N = new BigInteger(in.readLine());

        pollardRho(N);
        Collections.sort(list);
        for (long factor : list)
            sb.append(factor).append('\n');

        System.out.println(sb);
    }

    static void pollardRho(BigInteger n) {
        if (n.equals(BigInteger.ONE))
            return;
        else if (n.isProbablePrime(10)) {
            list.add(n.longValue());
            return;
        }
        BigInteger d = rho(n);
        pollardRho(d);
        pollardRho(n.divide(d));
    }

    public static BigInteger rho(BigInteger n) {
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return BigInteger.TWO;
        }
        BigInteger b = new BigInteger(n.bitLength(), rand);
        BigInteger x = new BigInteger(n.bitLength(), rand);
        BigInteger y = x;
        while (true) {
            x = f(x, b, n);
            y = f(f(y, b, n), b, n);
            BigInteger d = x.subtract(y).gcd(n);
            if (d.compareTo(BigInteger.ONE) > 0)
                return d;
        }
    }

    public static BigInteger f(BigInteger x, BigInteger b, BigInteger n) {
        return x.multiply(x).mod(n).add(b).mod(n);
    }

}