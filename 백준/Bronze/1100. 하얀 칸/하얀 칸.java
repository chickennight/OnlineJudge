import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            String s = in.readLine();
            for (int j = 0; j < 8; ++j) {
                if (s.charAt(j) == 'F' && (i + j) % 2 == 0) cnt++;
            }
        }
        System.out.print(cnt);
    }
}
