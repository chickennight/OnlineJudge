// 1930 정사면체

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int[] firstSide = {1, 0, 0, 0};
        int[] secondSide = {2, 3, 1, 2};
        int[] thirdSide = {3, 2, 3, 1};

        int K = Integer.parseInt(in.readLine());

        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(in.readLine());
            int[] diceA = new int[4], diceB = new int[4];

            for (int i = 0; i < 4; ++i)
                diceA[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 4; ++i)
                diceB[i] = Integer.parseInt(st.nextToken());

            int result = 0;
            int[] temp1, temp2;
            loop:
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (diceA[i] == diceB[j]) {
                        temp1 = new int[]{diceA[firstSide[i]], diceA[secondSide[i]], diceA[thirdSide[i]]};
                        temp2 = new int[]{diceB[firstSide[j]], diceB[secondSide[j]], diceB[thirdSide[j]]};

                        for (int k = 0; k < 3; ++k) {
                            if (Arrays.equals(temp1, temp2)) {
                                result = 1;
                                break loop;
                            }
                            temp2 = rotate(temp2);
                        }
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static int[] rotate(int[] arr) {
        return new int[]{arr[1], arr[2], arr[0]};
    }
}

