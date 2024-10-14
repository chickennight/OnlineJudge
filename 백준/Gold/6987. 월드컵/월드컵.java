import java.util.*;
import java.io.*;

public class Main {

    static int[][] play = new int[6][3];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 4; ++i) {
            st = new StringTokenizer(in.readLine());
            answer = 0;
            for (int j = 0; j < 18; ++j)
                play[j / 3][j % 3] = Integer.parseInt(st.nextToken());
            boolean tf = false;
            for (int j = 0; j < 6; ++j) {
                if (play[j][0] + play[j][1] + play[j][2] != 5) {
                    tf = true;
                    break;
                }
            }
            if (!tf)
                backTracking(0, 1);
            sb.append(answer).append(" ");
        }
        System.out.print(sb);
    }

    private static void backTracking(int idx, int next) {
        if (answer == 1)
            return;

        if (idx == 5) {
            answer = 1;
            return;
        }

        if (play[idx][0] > 0 && play[next][2] > 0) {
            play[idx][0]--;
            play[next][2]--;
            if (next == 5)
                backTracking(idx + 1, idx + 2);
            else
                backTracking(idx, next + 1);
            play[idx][0]++;
            play[next][2]++;
        }

        if (play[idx][1] > 0 && play[next][1] > 0) {
            play[idx][1]--;
            play[next][1]--;
            if (next == 5)
                backTracking(idx + 1, idx + 2);
            else
                backTracking(idx, next + 1);
            play[idx][1]++;
            play[next][1]++;
        }

        if (play[idx][2] > 0 && play[next][0] > 0) {
            play[idx][2]--;
            play[next][0]--;
            if (next == 5)
                backTracking(idx + 1, idx + 2);
            else
                backTracking(idx, next + 1);
            play[idx][2]++;
            play[next][0]++;
        }

    }
}