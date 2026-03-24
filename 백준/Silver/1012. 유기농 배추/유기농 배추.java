import java.util.*;
import java.io.*;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] bat;
    public static boolean[][] visit;
    public static int M,N,K;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(in.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            bat = new int[M][N];
            visit = new boolean[M][N];

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(in.readLine()," ");
                bat[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int count = 0;

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(bat[i][j] == 1 && !visit[i][j]) {
                        dfs(i,j);
                        count ++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y){
        visit[x][y] = true;
        int[] dirx = {-1,1,0,0};
        int[] diry = {0,0,-1,1};

        for(int i=0; i<4; i++) {
            int nextx = x + dirx[i];
            int nexty = y + diry[i];

            if(nextx >= 0 && nexty >= 0 && nextx < M && nexty < N) {
                if(bat[nextx][nexty] == 1 && !visit[nextx][nexty]) {
                    dfs(nextx,nexty);
                }
            }
        }
    }
}