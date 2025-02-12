// 17265 나의 인생에는 수학과 함께

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static char[][] map;
    private static int min, max, n;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine().trim());

        map = new char[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(0, 0, map[0][0] - '0', map[0][0]);
        System.out.println(max + " " + min);
    }

    private static void dfs(int x, int y, int previous, char operator) {
        int now = map[x][y] - '0';
        if (now >= 0 && now <= 5) {
            if (operator == '+')
                previous += now;
            else if (operator == '-')
                previous -= now;
            else if (operator == '*')
                previous *= now;
        } else {
            operator = map[x][y];
        }

        if (x == n - 1 && y == n - 1) {
            max = Math.max(previous, max);
            min = Math.min(previous, min);
            return;
        }

        if (x < n - 1) {
            dfs(x + 1, y, previous, operator);
        }

        if (y < n - 1) {
            dfs(x, y + 1, previous, operator);
        }
    }
}