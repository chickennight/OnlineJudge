import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int[][] map = new int[2001][2001];
        int stand = 1000;
        int[] res = new int[6];
        int[] ans = new int[10001];
        boolean[] check = new boolean[6];
        res[1] = 1;
        res[2] = 1;
        int y = stand;
        int x = stand;
        int d = 5;
        map[y][x] = 1;
        y = y - 1;
        x = x + 1;
        map[y][x] = 2;
        ans[1] = 1;
        ans[2] = 2;

        int[] dy = {-1, 1, 2, 1, -1, -2};
        int[] dx = {-1, -1, 0, 1, 1, 0};
        for (int i = 2; i < 10000; ++i) {
            int nd = (d + 1) % 6;
            int ny = y + dy[nd];
            int nx = x + dx[nd];

            if (map[ny][nx] != 0) {
                ny = y + dy[d];
                nx = x + dx[d];
                nd = d;
            }

            y = ny;
            x = nx;
            d = nd;
            Arrays.fill(check, false);

            for (int dir = 0; dir < 6; ++dir) {
                ny = y + dy[dir];
                nx = x + dx[dir];
                check[map[ny][nx]] = true;
            }
            int c;
            for (c = 1; c <= 5; ++c) {
                if (!check[c])
                    break;
            }

            int min = res[c];

            for (int r = c + 1; r <= 5; ++r) {
                if (min > res[r] && !check[r]) {
                    min = res[r];
                    c = r;
                }
            }
            map[y][x] = c;
            ans[i + 1] = c;
            res[c]++;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t1 = Integer.parseInt(in.readLine());

        for (int i = 1; i <= t1; ++i)
            sb.append(ans[Integer.parseInt(in.readLine())]).append('\n');

        System.out.println(sb);
    }
}