import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[30][30];

        for (int i = 0; i < 30; i++) {
            arr[i][i] = 1;
            arr[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        int T =Integer.parseInt(in.readLine());

        StringTokenizer st;

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(in.readLine());
            int N =Integer.parseInt(st.nextToken());
            int M =Integer.parseInt(st.nextToken());
            sb.append(arr[M][N]).append("\n");
        }

        System.out.println(sb);

    }

}