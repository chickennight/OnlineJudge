import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if (n == 1) {
            System.out.println(-1);
            return;
        }

        System.out.println((long) k * n / (n - 1) + ((long) k * n % (n - 1) > 0L ? 1 : 0));
    }

}
