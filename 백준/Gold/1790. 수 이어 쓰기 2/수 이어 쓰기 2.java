import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long target = 0;
        long numLen = 1;
        long numCnt = 9;

        while (K > numCnt * numLen) {
            K -= (int) (numLen * numCnt);
            target += numCnt;

            numLen++;
            numCnt *= 10;
        }

        target = (target + 1) + (K - 1) / numLen;

        if (target > N) {
            System.out.println(-1);
        } else {
            int idx = (int) ((K - 1) % numLen);
            System.out.println(String.valueOf(target).charAt(idx));
        }
    }
}