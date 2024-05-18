import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int reward = 0;
        int max = 0;

        for (int i = 0; i < N; ++i) {
            int maxDice = 0;
            int secondDice = 0;
            int count = 0;
            StringTokenizer st = new StringTokenizer(in.readLine());
            int[] dice = new int[4];
            for (int j = 0; j < 4; ++j)
                dice[j] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 6; ++j) {
                int tempCount = 0;
                for (int die : dice) {
                    if (j == die) {
                        tempCount = tempCount + 1;
                    }
                }
                if (count < tempCount && maxDice < j) {
                    count = tempCount;
                    maxDice = j;
                    secondDice = 0;
                } else if (count == tempCount && maxDice < j && count == 1) {
                    maxDice = j;
                } else if (count == tempCount) {
                    secondDice = j;
                }

            }

            if (count == 4) {
                reward = 50000 + maxDice * 5000;
            } else if (count == 3) {
                reward = 10000 + maxDice * 1000;
            } else if (count > 1 && secondDice > 0) {
                reward = 2000 + maxDice * 500 + secondDice * 500;
            } else if (count == 2) {
                reward = 1000 + maxDice * 100;
            } else if (count == 1) {
                reward = maxDice * 100;
            }

            if (reward > max) max = reward;
        }
        System.out.println(max);
    }
}