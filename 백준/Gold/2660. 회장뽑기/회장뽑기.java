import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i)
            for (int j = 1; j <= N; ++j)
                if (i != j)
                    arr[i][j] = INF;

        while (true) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1)
                break;

            arr[x][y] = arr[y][x] = 1;
        }

        for (int k = 1; k <= N; ++k)
            for (int i = 1; i <= N; ++i)
                for (int j = 1; j <= N; ++j)
                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];

        int readerScore = INF;

        int[] scoreArr = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            int score = 0;
            for (int j = 1; j <= N; ++j)
                if (arr[i][j] != INF)
                    score = Math.max(score, arr[i][j]);

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder title = new StringBuilder();
        title.append(readerScore).append(" ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i).append(" ");
            }
        }

        title.append(readerNum).append("\n");

        out.write(title.toString());
        out.write(body + "\n");
        out.flush();
        out.close();
        in.close();
    }

}
