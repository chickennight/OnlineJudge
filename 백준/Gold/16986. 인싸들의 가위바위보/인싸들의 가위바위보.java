import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[][] arr;
    static int[][] commands;
    static boolean[] used;
    static boolean tf;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        used = new boolean[n + 1];

        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= n; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new int[4][21];
        for (int i = 2; i <= 3; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= 20; ++j) {
                commands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(1);

        System.out.println(tf ? "1" : "0");
    }

    static void permutation(int depth) {
        if (tf)
            return;

        if (depth == n + 1) {
            if (playGame())
                tf = true;
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!used[i]) {
                used[i] = true;
                commands[1][depth] = i;
                permutation(depth + 1);
                used[i] = false;
            }
        }
    }

    static boolean playGame() {
        int[] cnt = new int[4];
        int[] play = new int[4];
        Arrays.fill(play, 1);

        int p1 = 1, p2 = 2, next;

        while (true) {
            next = 6 - p1 - p2;
            if (cnt[1] == k)
                return true;

            if (cnt[2] == k || cnt[3] == k)
                return false;

            if (play[1] == n + 1 || play[2] == 21 || play[3] == 21)
                return false;

            int winner = getWinner(p1, p2, play);
            cnt[winner]++;
            play[p1]++;
            play[p2]++;

            p1 = winner;
            p2 = next;
        }
    }

    static int getWinner(int p1, int p2, int[] play) {
        int action1 = commands[p1][play[p1]];
        int action2 = commands[p2][play[p2]];

        if (arr[action1][action2] == 2)
            return p1;
        else if (arr[action1][action2] == 1)
            return Math.max(p1, p2);
        else
            return p2;

    }
}