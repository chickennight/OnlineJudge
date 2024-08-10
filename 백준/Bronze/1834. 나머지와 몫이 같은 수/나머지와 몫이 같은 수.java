import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        BigInteger answer = new BigInteger("0");
        for (int i = 1; i < N; ++i)
            answer = answer.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(N)).add(BigInteger.valueOf(i)));

        System.out.println(answer);
    }
}