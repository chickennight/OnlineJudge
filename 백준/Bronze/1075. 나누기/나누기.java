import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int f = Integer.parseInt(in.readLine());

        int ans = (n / 100) * 100;

        while (ans % f != 0)
            ans++;

        System.out.printf("%02d", ans % 100);
    }

}