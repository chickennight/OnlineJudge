import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < N; ++i) {
            int idx = Collections.binarySearch(list, arr[i]);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx < list.size()) {
                list.set(idx, arr[i]);
            } else {
                list.add(arr[i]);
            }
        }

        System.out.println(N - list.size());
    }

}