// 25603 짱해커 이동식

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            cost[i] = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < K; ++i)
            map.put(cost[i], map.getOrDefault(cost[i], 0) + 1);


        int ans = map.firstKey();

        for (int i = K; i < N; ++i) {
            int left = cost[i - K];
            int right = cost[i];

            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }

            map.put(right, map.getOrDefault(right, 0) + 1);

            ans = Math.max(ans, map.firstKey());
        }

        System.out.println(ans);
    }
}

