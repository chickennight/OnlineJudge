import java.util.*;
import java.io.*;

public class Main {

    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] kx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] ky = {1, -1, 2, -2, 2, -2, 1, -1};

    static int n, m;
    static int[][] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];

        st = new StringTokenizer(in.readLine());
        int queen = Integer.parseInt(st.nextToken());

        for (int i = 0; i < queen; ++i)
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

        st = new StringTokenizer(in.readLine());
        int knight = Integer.parseInt(st.nextToken());

        for (int i = 0; i < knight; ++i)
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;

        st = new StringTokenizer(in.readLine());
        int pawn = Integer.parseInt(st.nextToken());

        for (int i = 0; i < pawn; ++i)
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 3;

        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                if (arr[i][j] == 1)
                    queenCheck(i, j);
                else if (arr[i][j] == 2)
                    knightCheck(i, j);

        int cnt = 0;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                if (arr[i][j] == 0)
                    cnt++;

        System.out.println(cnt);

    }
    
    static void queenCheck(int x, int y) {
        for (int d = 0; d < 8; ++d) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (inRange(nx, ny) && (arr[nx][ny] == 0 || arr[nx][ny] == -1)) {
                    if (arr[nx][ny] == 0) 
                        arr[nx][ny] = -1;
                } else break;
            }
        }
    }
    
    static void knightCheck(int x, int y) {
        for (int d = 0; d < 8; ++d) {
            int nx = x + kx[d];
            int ny = y + ky[d];
            if (inRange(nx, ny) && arr[nx][ny] == 0) 
                arr[nx][ny] = -1;
        }
    }

    static boolean inRange(int i, int j) {
        return 1 <= i && i <= n && 1 <= j && j <= m;
    }
}