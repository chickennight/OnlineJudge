import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static Map<String, Integer> hashMap;
    static char[][] map;
    static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static final int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; ++i)
            map[i] = in.readLine().toCharArray();

        hashMap = new HashMap<>();

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                addWord(i, j, 1, String.valueOf(map[i][j]));

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            sb.append(hashMap.getOrDefault(in.readLine(), 0)).append('\n');
        }

        System.out.println(sb);
    }

    static void addWord(int x, int y, int depth, String word) {
        if (depth == 6) return;
        hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        for (int d = 0; d < dx.length; ++d) {
            int nx = (x + dx[d] + N) % N;
            int ny = (y + dy[d] + M) % M;
            addWord(nx, ny, depth + 1, word + map[nx][ny]);
        }
    }
}