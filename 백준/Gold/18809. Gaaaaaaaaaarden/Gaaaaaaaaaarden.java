import java.io.*;
import java.util.*;


public class Main {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, g, r;
    static int[][] map;
    static boolean[][] rVisited;
    static boolean[][] gVisited;
    static int ans = 0;
    static boolean[] visited;
    static int[][] rTime;
    static int[][] gTime;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] copyMap;
    static ArrayList<Node> list = new ArrayList<>();
    static ArrayList<Node> green = new ArrayList<>();
    static ArrayList<Node> red = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[list.size()];
        gDFS(0, 0);
        System.out.println(ans);
    }

    public static void gDFS(int depth, int idx) {
        if (depth == g) {
            green.clear();
            for (int i = 0; i < list.size(); ++i) {
                if (visited[i]) {
                    Node a = list.get(i);
                    green.add(a);
                }
            }
            rDFS(0, 0);
            return;
        }
        for (int i = idx; i < list.size(); ++i) {
            if (!visited[i]) {
                visited[i] = true;
                gDFS(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void rDFS(int depth, int idx) {
        if (depth == r) {
            red.clear();
            for (int i = 0; i < list.size(); ++i) {
                Node a = list.get(i);
                if (visited[i] && !green.contains(a)) {
                    red.add(a);
                }
            }
            bfs();
            return;
        }
        for (int i = idx; i < list.size(); ++i) {
            if (!visited[i]) {
                visited[i] = true;
                rDFS(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void bfs() {
        int flower = 0;
        gVisited = new boolean[n + 1][m + 1];
        gTime = new int[n + 1][m + 1];
        rVisited = new boolean[n + 1][m + 1];
        rTime = new int[n + 1][m + 1];

        copyMap();
        Queue<Node> rq = new LinkedList<>();
        Queue<Node> gq = new LinkedList<>();

        for (Node node : red) {
            rq.add(node);
            rVisited[node.x][node.y] = true;
        }
        for (Node node : green) {
            gVisited[node.x][node.y] = true;
            gq.add(node);
        }


        while (!rq.isEmpty() && !gq.isEmpty()) {

            int size = gq.size();
            Node now;
            while (size-- > 0) {
                now = gq.poll();
                gVisited[now.x][now.y] = true;

                if (copyMap[now.x][now.y] == 3)
                    continue;


                for (int d = 0; d < 4; ++d) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    if (inRange(nx, ny) && (copyMap[nx][ny] == 1 || copyMap[nx][ny] == 2) && !gVisited[nx][ny]) {
                        gVisited[nx][ny] = true;
                        gTime[nx][ny] = gTime[now.x][now.y] + 1;
                        gq.add(new Node(nx, ny));
                    }
                }
            }

            if (!rq.isEmpty()) {
                size = rq.size();
                while (size-- > 0) {
                    now = rq.poll();
                    rVisited[now.x][now.y] = true;

                    if (copyMap[now.x][now.y] == 3)
                        continue;

                    for (int d = 0; d < 4; ++d) {
                        int nx = now.x + dx[d];
                        int ny = now.y + dy[d];
                        if (inRange(nx, ny) && (copyMap[nx][ny] == 1 || copyMap[nx][ny] == 2) && !rVisited[nx][ny]) {
                            rVisited[nx][ny] = true;
                            rTime[nx][ny] = rTime[now.x][now.y] + 1;
                            if (rTime[nx][ny] == gTime[nx][ny]) {

                                flower++;
                                copyMap[nx][ny] = 3;
                            } else {
                                rq.add(new Node(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        ans = Math.max(ans, flower);
    }

    public static void copyMap() {
        copyMap = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i)
            if (m >= 0) System.arraycopy(map[i], 1, copyMap[i], 1, m);
    }

    public static boolean inRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= m;
    }
}

