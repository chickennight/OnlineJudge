import java.io.*;
import java.util.*;

class Dirt {
    int x;
    int y;
    int cnt;

    Dirt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Dirt(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

class Node {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    private static int answer, C, R;
    private static boolean[] check;
    private static char[][] map;
    private static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(in.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) break;

            map = new char[R][C];
            Dirt[] dirt = new Dirt[11];
            int idx = 1;

            for (int i = 0; i < R; ++i) {
                String S = in.readLine();
                for (int j = 0; j < C; ++j) {
                    map[i][j] = S.charAt(j);
                    if (map[i][j] == 'o') {
                        dirt[0] = new Dirt(j, i);
                    } else if (map[i][j] == '*') {
                        dirt[idx++] = new Dirt(j, i);
                    }
                }
            }

            list = new ArrayList[idx];
            for (int i = 0; i < idx; ++i)
                list[i] = new ArrayList<>();

            for (int s = 0; s < idx - 1; ++s) {
                for (int e = s + 1; e < idx; ++e) {
                    int weight = BFS(dirt[s], dirt[e]);

                    if (weight == -1)
                        continue;

                    list[s].add(new Node(e, weight));
                    list[e].add(new Node(s, weight));
                }
            }

            check = new boolean[idx];
            check[0] = true;
            Permutation(0, 0, 0, idx);

            sb.append(answer == Integer.MAX_VALUE ? -1 : answer).append('\n');
        }

        System.out.println(sb);
    }

    static int BFS(Dirt start, Dirt end) {
        Queue<Dirt> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.offer(new Dirt(start.x, start.y, 0));
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Dirt now = q.poll();

            if (now.y == end.y && now.x == end.x)
                return now.cnt;

            for (int d = 0; d < 4; ++d) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= C || ny < 0 || ny >= R || visited[ny][nx] || map[ny][nx] == 'x') continue;
                q.offer(new Dirt(nx, ny, now.cnt + 1));
                visited[ny][nx] = true;
            }
        }
        return -1;
    }

    static void Permutation(int start, int depth, int sum, int dusts) {
        if (depth == dusts - 1) {
            answer = Math.min(answer, sum);
            return;
        }

        for (Node next : list[start]) {
            if (check[next.end]) continue;
            check[next.end] = true;
            Permutation(next.end, depth + 1, sum + next.weight, dusts);
            check[next.end] = false;
        }
    }
}

