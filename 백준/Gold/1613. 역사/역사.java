import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        boolean[][] event = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            event[a][b] = true;
        }


        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                for (int k = 1; k <= N; ++k) {
                    if (event[j][i] && event[i][k])
                        event[j][k] = true;
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        int S = Integer.parseInt(in.readLine());

        for (int i = 0; i < S; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (event[a][b])
                sb.append(-1 + " ");
            else if (event[b][a])
                sb.append(1 + " ");
            else
                sb.append(0);

            sb.append("\n");
        }

        System.out.println(sb);

    }

}
