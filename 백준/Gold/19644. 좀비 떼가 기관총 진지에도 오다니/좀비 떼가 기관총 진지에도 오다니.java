import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int Ml = Integer.parseInt(st.nextToken());
        int Mk = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(in.readLine());
        boolean tf = true;
        int[] map = new int[L];
        boolean[] bomber = new boolean[L];
        int start = -Ml + 1;
        int end = 0;
        int bomb = Ml - 1;
        int full = Mk * Ml;

        int shoot;
        while (true) {
            map[end] = Integer.parseInt(in.readLine());
            shoot = full - bomb * Mk;
            if (shoot < map[end]) {
                if (--C < 0) {
                    tf = false;
                    break;
                }
                bomb++;
                bomber[end] = true;
            }

            if (start < 0 || bomber[start])
                bomb--;

            start++;

            if (++end == L)
                break;
        }

        System.out.println(tf ? "YES" : "NO");
    }

}