import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < R; ++i) {
            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    move1();
                    break;
                case 2:
                    move2();
                    break;
                case 3:
                    move3();
                    break;
                case 4:
                    move4();
                    break;
                case 5:
                    move5();
                    break;
                case 6:
                    move6();
                    break;

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] line : arr) {
            for (int j = 0; j < arr[0].length; ++j) {
                sb.append(line[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void move1() {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N / 2; ++j) {
                int temp = arr[j][i];
                arr[j][i] = arr[N - 1 - j][i];
                arr[N - 1 - j][i] = temp;
            }
        }
    }

    private static void move2() {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M / 2; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M - 1 - j];
                arr[i][M - 1 - j] = temp;
            }
        }
    }

    private static void move3() {
        int N = arr.length;
        int M = arr[0].length;
        int[][] tempArr = new int[M][N];
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < M / 2; ++j) {
                tempArr[j][i] = arr[N - 1 - i][j];
                tempArr[j][N - 1 - i] = arr[i][j];
                tempArr[M - 1 - j][N - 1 - i] = arr[i][M - 1 - j];
                tempArr[M - 1 - j][i] = arr[N - 1 - i][M - 1 - j];
            }
        }

        arr = tempArr;
    }

    private static void move4() {
        int N = arr.length;
        int M = arr[0].length;
        int[][] tempArr = new int[M][N];
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < M / 2; ++j) {
                tempArr[j][i] = arr[i][M - 1 - j];
                tempArr[j][N - 1 - i] = arr[N - 1 - i][M - 1 - j];
                tempArr[M - 1 - j][N - 1 - i] = arr[N - 1 - i][j];
                tempArr[M - 1 - j][i] = arr[i][j];
            }
        }

        arr = tempArr;
    }

    private static void move5() {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < M / 2; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[i + N / 2][j];
                arr[i + N / 2][j] = arr[i + N / 2][j + M / 2];
                arr[i + N / 2][j + M / 2] = arr[i][j + M / 2];
                arr[i][j + M / 2] = temp;
            }
        }
    }

    private static void move6() {
        int N = arr.length;
        int M = arr[0].length;
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < M / 2; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][j + M / 2];
                arr[i][j + M / 2] = arr[i + N / 2][j + M / 2];
                arr[i + N / 2][j + M / 2] = arr[i + N / 2][j];
                arr[i + N / 2][j] = temp;
            }
        }
    }
}
