// 2290 LCD Test

import java.io.*;
import java.util.*;

public class Main {

    private static int s;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();
        int w = (3 + s) * n.length();
        int h = 2 * s + 3;

        char[][] arr = new char[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(arr[i], ' ');
        }

        int idx = 0;
        for (int i = 0; i < w; i += (s + 3)) {
            switch (n.charAt(idx)) {
                case '1':
                    col2(arr, i);
                    col4(arr, i);
                    break;
                case '2':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col2(arr, i);
                    col3(arr, i);
                    break;
                case '3':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col2(arr, i);
                    col4(arr, i);
                    break;
                case '4':
                    row2(arr, i);
                    col1(arr, i);
                    col2(arr, i);
                    col4(arr, i);
                    break;
                case '5':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col1(arr, i);
                    col4(arr, i);
                    break;
                case '6':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col1(arr, i);
                    col3(arr, i);
                    col4(arr, i);
                    break;
                case '7':
                    row1(arr, i);
                    col2(arr, i);
                    col4(arr, i);
                    break;
                case '8':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col1(arr, i);
                    col2(arr, i);
                    col3(arr, i);
                    col4(arr, i);
                    break;
                case '9':
                    row1(arr, i);
                    row2(arr, i);
                    row3(arr, i);
                    col1(arr, i);
                    col2(arr, i);
                    col4(arr, i);
                    break;
                case '0':
                    row1(arr, i);
                    row3(arr, i);
                    col1(arr, i);
                    col2(arr, i);
                    col3(arr, i);
                    col4(arr, i);
                    break;
            }
            idx++;
        }

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    private static void row1(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[0][idx + 1 + i] = '-';
    }

    private static void row2(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[s + 1][idx + 1 + i] = '-';
    }

    private static void row3(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[2 * s + 2][idx + 1 + i] = '-';
    }

    private static void col1(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[1 + i][idx] = '|';
    }

    private static void col2(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[1 + i][idx + 1 + s] = '|';
    }

    private static void col3(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[s + 2 + i][idx] = '|';
    }

    private static void col4(char[][] arr, int idx) {
        for (int i = 0; i < s; ++i)
            arr[s + 2 + i][idx + 1 + s] = '|';
    }

}