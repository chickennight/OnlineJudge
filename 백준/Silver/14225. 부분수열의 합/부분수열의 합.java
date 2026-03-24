// 14225 부분수열의 합

import java.io.*;
import java.text.BreakIterator;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        boolean[] use = new boolean[N];
        recursive(set, arr, use, 0);

        for (int i = 1; i < 100000 * 20; ++i) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void recursive(Set<Integer> set, int[] arr, boolean[] use, int idx) {
        if (idx == arr.length) {
            int num = 0;
            for (int i = 0; i < arr.length; ++i) {
                if (use[i]) {
                    num += arr[i];
                }
            }
            set.add(num);
            return;
        }

        use[idx] = true;
        recursive(set, arr, use, idx + 1);
        use[idx] = false;
        recursive(set, arr, use, idx + 1);
    }

}