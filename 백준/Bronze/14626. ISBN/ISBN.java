// 14626 ISBN

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        char[] numbers = st.nextToken().toCharArray();
        int total = 0;
        int idx = -1;

        for (int i = 0; i < 13; ++i) {
            if (numbers[i] == '*') {
                idx = i;
                continue;
            }

            int num = numbers[i] - '0';
            if (i % 2 == 0) total += num;
            else total += num * 3;
        }

        for (int i = 0; i <= 9; ++i) {
            int tempTotal = total;
            if (idx % 2 == 0) {
                tempTotal += i;
            } else {
                tempTotal += i * 3;
            }

            if (tempTotal % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}