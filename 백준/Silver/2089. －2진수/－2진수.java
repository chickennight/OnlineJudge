import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            sb.append(0);
        } else {
            while (N != 1) {
                sb.append(Math.abs(N % -2));

                N = (int) (Math.ceil((double) N / -2));
            }
            sb.append(N);
        }
        System.out.println(sb.reverse());
    }
}