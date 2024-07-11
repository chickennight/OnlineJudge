import java.util.*;
import java.io.*;

public class Main {
    static int cost;
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        cost = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; ++i) {
            visited[i] = true;
            solve(i, i, 0, 0);
        }

        System.out.println(cost);
    }

    private static void solve(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                cost = Math.min(cost, sum);
            }
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                solve(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}