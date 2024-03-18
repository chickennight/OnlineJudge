import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] bowl;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bowl = new int[N][25];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            bowl[i][0] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while (isLarge()) {
            count++;
            addFish();
            roll();
            spread();
            unFold();
            fold();
            spread();
            unFold();
        }

        System.out.println(count);
    }

    public static boolean isLarge() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, bowl[i][0]);
            max = Math.max(max, bowl[i][0]);
        }

        return max - min > K;
    }


    public static void addFish() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++)
            min = Math.min(min, bowl[i][0]);

        for (int i = 0; i < N; i++) {
            if (bowl[i][0] == min)
                bowl[i][0]++;
        }
    }


    public static void roll() {
        int startX = 0;
        int x = 1;
        int y = 1;
        while (startX + x + y <= N) {
            for (int i = x - 1; i >= 0; i--) {
                for (int j = 0; j < y; j++) {
                    int nx = startX + x + j;
                    int ny = x - i;
                    bowl[nx][ny] = bowl[startX + i][j];
                    bowl[startX + i][j] = 0;
                }
            }
            startX += x;
            if (x == y) y++;
            else x++;
        }
    }

    public static void spread() {
        int[][] copy = new int[N][25];
        boolean[][] visit = new boolean[N][25];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < 25; y++) {
                visit[x][y] = true;
                if (bowl[x][y] == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (inrange(nx, ny) && !visit[nx][ny] && bowl[nx][ny] != 0) {
                        int diff = (bowl[x][y] - bowl[nx][ny]) / 5;
                        if (Math.abs(diff) >= 1) {
                            copy[x][y] -= diff;
                            copy[nx][ny] += diff;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < 25; y++) {
                bowl[x][y] += copy[x][y];
            }
        }
    }


    public static void unFold() {
        int x = 0;
        while (bowl[x][0] == 0) x++;

        int idx = 0;
        int[] copy = new int[N];
        for (int i = x; i < N; i++) {
            for (int j = 0; j < 25; j++) {
                if (bowl[i][j] == 0) break;
                copy[idx++] = bowl[i][j];
                bowl[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            bowl[i][0] = copy[i];
        }
    }


    public static void fold() {
        for (int i = 0; i < N / 2; i++) {
            bowl[N - 1 - i][1] = bowl[i][0];
            bowl[i][0] = 0;
        }

        for (int i = 0; i < N / 4; i++) {
            for (int j = 0; j < 2; j++) {
                bowl[N - 1 - i][3 - j] = bowl[N / 2 + i][j];
                bowl[N / 2 + i][j] = 0;
            }
        }
    }

    public static boolean inrange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < 25;
    }
}
