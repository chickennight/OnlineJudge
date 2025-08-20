// 21738 얼음깨기 펭귄

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n + 1; ++i)
            list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int ans = n - 1;
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        q.add(p);
        visit[p] = true;

        int len = -1;
        int cnt = 0;
        while (!q.isEmpty() && cnt < 2) {
            len++;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int num = q.poll();
                if (num <= s && cnt < 2) {
                    ans -= len;
                    cnt++;
                    continue;
                }

                for (int next : list.get(num)) {
                    if (!visit[next]) {
                        q.add(next);
                        visit[next] = true;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}