// 1138 한 줄로 서기

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[] length = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; ++i)
            length[i] = Integer.parseInt(st.nextToken());


        for (int i = n; i >= 1; --i)
            ans.add(length[i], i);

        for (int k : ans)
            sb.append(k).append(" ");

        System.out.println(sb);
    }
}

