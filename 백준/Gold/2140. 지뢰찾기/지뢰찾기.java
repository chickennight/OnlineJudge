// 2140 지뢰찾기

import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; ++i)
            map[i] = in.readLine().toCharArray();

        int cnt = 0;

        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < N; ++j) {
                boolean possible = true;
                if (map[i][j] == '#') {
                    for (int d = 0; d < 8; ++d) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (map[nx][ny] == '0') {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        calc(i, j);
                        map[i][j] = 'B';
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static void calc(int x, int y) {
        for (int d = 0; d < 8; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            char c = map[nx][ny];
            if (c != '#' && c != 'B')
                map[nx][ny] = (char) (c - 1);
        }
    }

}