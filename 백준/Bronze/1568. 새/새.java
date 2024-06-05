import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int bird = 1;
        int cnt = 0;

        while (n >= 1) {
            if (n < bird) {
                bird = 1;
            }
            n -= bird;
            bird++;
            cnt++;
        }

        System.out.println(cnt);
    }
}