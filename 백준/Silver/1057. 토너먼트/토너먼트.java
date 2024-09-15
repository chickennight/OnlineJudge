import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int zimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (zimin != hansu) {
            zimin = zimin / 2 + zimin % 2;
            hansu = hansu / 2 + hansu % 2;
            cnt++;
        }

        System.out.println(cnt);
    }
}