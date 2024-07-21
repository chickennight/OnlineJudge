import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        System.out.println(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < Math.abs(r1 + r2) ? "YES" : "NO");
    }
}