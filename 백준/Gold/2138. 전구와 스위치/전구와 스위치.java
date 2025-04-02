// 2138 전구와 스위치

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String startString = in.readLine();
        String endString = in.readLine();

        int[] start = new int[n];
        for (int i = 0; i < n; ++i)
            start[i] = startString.charAt(i) - '0';

        int[] end = new int[n];
        for (int i = 0; i < n; ++i)
            end[i] = endString.charAt(i) - '0';

        int[] reverse = Arrays.copyOf(start, n);
        reverse[0] = 1 - reverse[0];
        reverse[1] = 1 - reverse[1];

        int answer = solve(n, start, end);
        int answer2 = solve(n, reverse, end);

        if (answer2 != -1)
            answer2++;

        if (answer == -1)
            System.out.println(answer2);
        else if (answer2 == -1)
            System.out.println(answer);
        else
            System.out.println(Math.min(answer2, answer));
    }

    private static int solve(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n - 1; ++i) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = 1 - a[i];
                a[i + 1] = 1 - a[i + 1];
                if (i != n - 2)
                    a[i + 2] = 1 - a[i + 2];
            }
        }

        return a[n - 1] != b[n - 1] ? -1 : cnt;

    }
}