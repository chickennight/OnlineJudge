// 15565 귀여운 라이언

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            if (st.nextToken().equals("1"))
                list.add(i);
        }
        
        if (list.size() < K) {
            System.out.println(-1);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= list.size() - K; ++i) {
                int start = list.get(i);
                int end = list.get(i + K - 1);
                ans = Math.min(ans, end - start + 1);
            }
            System.out.println(ans);
        }

    }
}