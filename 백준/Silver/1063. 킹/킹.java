import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            String line = in.readLine();
            char[] tempKing = king.clone();
            char[] tempStone = stone.clone();
            move(line, tempKing);
            if (outOfRange(tempKing))
                continue;
            if (Arrays.equals(tempKing, tempStone)) {
                move(line, tempStone);
                if (outOfRange(tempStone))
                    continue;
            }
            king = tempKing;
            stone = tempStone;
        }

        System.out.println(king);
        System.out.println(stone);
    }

    public static boolean outOfRange(char[] next) {
        return next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8';
    }

    public static void move(String order, char[] next) {
        switch (order) {
            case "R":
                next[0]++;
                break;
            case "L":
                next[0]--;
                break;
            case "B":
                next[1]--;
                break;
            case "T":
                next[1]++;
                break;
            case "RT":
                next[0]++;
                next[1]++;
                break;
            case "LT":
                next[0]--;
                next[1]++;
                break;
            case "RB":
                next[0]++;
                next[1]--;
                break;
            case "LB":
                next[0]--;
                next[1]--;
                break;
        }
    }
}