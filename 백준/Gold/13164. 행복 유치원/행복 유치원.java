import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(solve(arr, n, k));
    }

    private static int solve(int[] arr, int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < n - k; ++i) {
            result += list.get(i);
        }

        return result;
    }

}