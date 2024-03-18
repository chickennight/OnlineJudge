import java.util.*;
import java.io.*;

class Prisoner implements Comparable<Prisoner> {
    int x, y, door;

    public Prisoner(int x, int y, int door) {
        this.x = x;
        this.y = y;
        this.door = door;
    }

    @Override
    public int compareTo(Prisoner o) {
        return Integer.compare(this.door, o.door);
    }
}

public class Main {

    private final static int[] dx = {0, 0, 1, -1};
    private final static int[] dy = {1, -1, 0, 0};

    private static int h, w;
    private static char[][] map;

    private static int[][] A, B, S;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        int idx;
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            Prisoner[] prisoners = new Prisoner[2];
            idx = 0;

            String input;
            for (int i = 0; i < h; ++i) {
                input = in.readLine();
                for (int j = 0; j < w; ++j) {
                    map[i + 1][j + 1] = input.charAt(j);
                    if (map[i + 1][j + 1] == '$')
                        prisoners[idx++] = new Prisoner(i + 1, j + 1, 0);
                }
            }

            S = bfs(new Prisoner(0, 0, 0));
            A = bfs(prisoners[0]);
            B = bfs(prisoners[1]);

            sb.append(getMin()).append('\n');
        }

        System.out.println(sb);
    }

    private static int[][] bfs(Prisoner p) {
        PriorityQueue<Prisoner> q = new PriorityQueue<>();
        visited = new boolean[h + 2][w + 2];
        int[][] result = new int[h + 2][w + 2];

        q.add(p);
        visited[p.x][p.y] = true;

        int nx, ny, cnt;
        while (!q.isEmpty()) {
            Prisoner now = q.poll();
            cnt = now.door;
            result[now.x][now.y] = cnt;

            for (int d = 0; d < 4; ++d) {
                nx = now.x + dx[d];
                ny = now.y + dy[d];
                if (0 <= nx && nx < h + 2 && 0 <= ny && ny < w + 2 && !visited[nx][ny]
                        && map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    q.add(new Prisoner(nx, ny, map[nx][ny] == '#' ? cnt + 1 : cnt));
                }
            }
        }
        return result;
    }

    private static int getMin() {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < h + 2; ++i) {
            for (int j = 0; j < w + 2; ++j) {
                if (map[i][j] == '*')
                    continue;

                int sum = A[i][j] + B[i][j] + S[i][j];

                if (map[i][j] == '#')
                    sum -= 2;

                if (result > sum && visited[i][j])
                    result = sum;
            }
        }

        return result;
    }
}