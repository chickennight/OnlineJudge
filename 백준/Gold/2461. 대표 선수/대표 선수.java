import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; ++i)
            Arrays.sort(map[i]);

        int[] arr = new int[N];
        int result = (int) 10e9;
        int minArrayIdx = 0;
        do {
            int max = 0;
            int min = (int) 10e9;
            for (int i = 0; i < N; ++i) {
                if (map[i][arr[i]] > max) {
                    max = map[i][arr[i]];
                }
                if (map[i][arr[i]] < min) {
                    min = map[i][arr[i]];
                    minArrayIdx = i;
                }
            }
            result = Math.min(result, max - min);
            arr[minArrayIdx]++;
        } while (arr[minArrayIdx] != M);

        System.out.println(result);
    }
}