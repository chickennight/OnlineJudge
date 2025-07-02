// 13265 색칠하기

import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> list;
    private static int[] color;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        loop:
        while (T-- > 0) {
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n; ++i)
                list.add(new ArrayList<>());

            for (int i = 0; i < m; ++i) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            color = new int[n + 1];

            for (int i = 1; i <= n; ++i) {
                if (color[i] == 0)
                    if (bfs(i)) {
                        sb.append("impossible\n");
                        continue loop;
                    }
            }

            sb.append("possible\n");

        }
        System.out.println(sb);

    }

    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list.get(now)) {
                if (color[next] == 0) {
                    q.add(next);
                    color[next] = color[now] * -1;
                } else if (color[next] + color[now] != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}