import java.util.*;
import java.io.*;

public class Main {
    private static int[][] map;
    private static Set<String> result;
    private static int[] selected;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        result = new HashSet<>();
        selected = new int[6];

        for (int i = 0; i < 5; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 5; ++j) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                dfs(0, i, j);
            }
        }
        System.out.println(result.size());
    }

    private static void dfs(int depth, int x, int y) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; ++i) {
                sb.append(selected[i]);
            }
            result.add(sb.toString());
            return;
        }

        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny)) {
                selected[depth] = map[nx][ny];
                dfs(depth + 1, nx, ny);
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}