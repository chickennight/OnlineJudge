// 24542 튜터-튜티 관계의 수

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            list.add(new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            if (!visited[i]) {
                int cnt = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int j : list.get(now)) {
                        if (!visited[j]) {
                            q.add(j);
                            visited[j] = true;
                            cnt++;
                        }
                    }
                }
                ansList.add(cnt);
            }
        }
        long ans = 1;
        for (int n : ansList)
            ans = ans * n % 1000000007;

        System.out.println(ans);
    }

}