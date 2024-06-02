import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int k;
        while (n-- > 0) {
            k = Integer.parseInt(in.readLine());
            while (k-- > 0) {
                sb.append('=');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}