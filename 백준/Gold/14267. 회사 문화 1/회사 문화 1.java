import java.util.*;
import java.io.*;

public class Main {

    private static List<Integer>[] list;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i < n + 1; ++i) {
            int sup = Integer.parseInt(st.nextToken());
            if (sup != -1) {
                list[sup].add(i);
            }
        }

        arr = new int[n + 1];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(in.readLine());
            int emp = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[emp] += w;

        }
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; ++i)
            sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }

    private static void dfs(int idx) {
        for (int nxt : list[idx]) {
            arr[nxt] += arr[idx];
            dfs(nxt);
        }
    }
}
