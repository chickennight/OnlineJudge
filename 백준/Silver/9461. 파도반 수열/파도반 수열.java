// 9461 파도반 수열

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for (int i = 6; i < 101; ++i)
            arr[i] = arr[i - 1] + arr[i - 5];

        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            sb.append(arr[N]).append('\n');
        }

        System.out.println(sb);
    }

}
