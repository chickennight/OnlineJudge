import java.util.*;
import java.io.*;

public class Main {

    static int T, n;
    static int[] inDegree;
    static boolean[][] arr;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        int m, now, a, b;
        while (T-- > 0) {
            q = new LinkedList<>();
            n = Integer.parseInt(in.readLine());
            inDegree = new int[n + 1];
            arr = new boolean[n + 1][n + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; ++i) {
                now = Integer.parseInt(st.nextToken());
                inDegree[now] = i;
                for (int j = 1; j <= n; ++j)
                    if (j != now && !arr[j][now])
                        arr[now][j] = true;

            }

            m = Integer.parseInt(in.readLine());
            while (m-- > 0) {
                st = new StringTokenizer(in.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                swap(a, b);
            }

            ans.append(topology()).append("\n");
        }
        System.out.println(ans);
    }

    static void swap(int a, int b) {
        if (!arr[a][b]) {
            arr[a][b] = true;
            arr[b][a] = false;
            inDegree[a]--;
            inDegree[b]++;
        } else {
            arr[a][b] = false;
            arr[b][a] = true;
            inDegree[a]++;
            inDegree[b]--;
        }
    }

    static String topology() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i)
            if (inDegree[i] == 0)
                q.add(i);

        for (int i = 1; i <= n; ++i) {
            if (q.isEmpty())
                return "IMPOSSIBLE";
            else if (q.size() > 1)
                return "?";

            int now = q.poll();
            sb.append(now).append(" ");

            for (int j = 1; j <= n; ++j) {
                if (arr[now][j]) {
                    arr[now][j] = false;
                    inDegree[j]--;
                    if (inDegree[j] == 0) q.add(j);
                }
            }
        }
        return sb.toString();
    }
}