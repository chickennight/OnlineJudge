// 16432 떡장수와 호랑이

import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] arr;
    private static int[] num;
    private static boolean isLive;
    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        arr = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            arr[i] = new ArrayList<>();
        num = new int[N];
        int pre = 0;
        boolean tf = false;
        isLive = false;
        sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; ++j) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }

            if (size == 1) {
                if (pre == arr[i].get(0)) {
                    tf = true;
                    break;
                } else {
                    pre = arr[i].get(0);
                }
                continue;
            } else if (size == 2) {
                if (pre == arr[i].get(0)) {
                    pre = arr[i].get(1);
                    continue;
                } else if (pre == arr[i].get(1)) {
                    pre = arr[i].get(0);
                    continue;
                }
            }
            pre = 0;
        }

        if (!tf)
            dfs(0, 0);

        System.out.println(isLive ? sb : String.valueOf(-1));
    }

    private static void dfs(int pre, int depth) {
        if (isLive)
            return;

        if (depth == N) {
            isLive = true;
            for (int i = 0; i < N; ++i) {
                sb.append(num[i]).append("\n");
            }
            return;
        }

        for (int i = 0; i < arr[depth].size(); ++i) {
            if (isLive) return;
            if (pre == arr[depth].get((i))) continue;
            num[depth] = arr[depth].get((i));
            dfs(arr[depth].get((i)), depth + 1);
        }
    }
}