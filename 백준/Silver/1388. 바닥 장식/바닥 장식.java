import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static char[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            String str = in.readLine();
            for (int j = 0; j < M; ++j) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (visited[i][j]) continue;
                dfs(i, j, arr[i][j] == '-');
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;
        if (row) {
            j++;
            if (j < M && arr[i][j] == '-') dfs(i, j, true);
        } else {
            i++;
            if (i < N && arr[i][j] != '-') dfs(i, j, false);
        }

    }

}
