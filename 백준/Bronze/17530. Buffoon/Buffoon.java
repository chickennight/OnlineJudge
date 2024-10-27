import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int carlos = Integer.parseInt(in.readLine());

        String ans = "S";
        for (int i = 0; i < n - 1; ++i) {
            int other = Integer.parseInt(in.readLine());
            if (other > carlos) {
                ans = "N";
                break;
            }
        }

        System.out.print(ans);
    }
}