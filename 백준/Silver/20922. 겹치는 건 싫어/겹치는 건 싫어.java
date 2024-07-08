import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0;
        int answer = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < N) {
            while (end < N && map.getOrDefault(arr[end], 0) + 1 <= K) {
                map.put(arr[end], map.getOrDefault(arr[end++], 0) + 1);
            }
            int len = end - start;
            answer = Math.max(answer, len);

            map.put(arr[start], map.getOrDefault(arr[start++], 0) - 1);
        }

        System.out.print(answer);
    }
}