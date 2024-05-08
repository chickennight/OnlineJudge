import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        int cnt0 = 0;
        int cnt1 = 0;
        for (char c : arr) {
            if (c == '0') cnt0++;
            else cnt1++;
        }
        cnt0 /= 2;
        cnt1 /= 2;

        for (int i = 0; i < arr.length && cnt1 != 0; ++i) {
            if (arr[i] == '1') {
                cnt1--;
                arr[i] = 0;
            }
        }

        for (int i = arr.length - 1; i >= 0 && cnt0 != 0; --i) {
            if (arr[i] == '0') {
                cnt0--;
                arr[i] = 0;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char c : arr) {
            if (c != 0)
                answer.append(c);
        }
        System.out.println(answer);

    }
}