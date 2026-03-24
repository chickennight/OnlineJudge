import java.util.*;
import java.io.*;
import java.util.function.IntUnaryOperator;

public class Main {
    static int N, K;
    static ArrayList<ArrayList<Integer>> list;
    static int[] arr, time;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N + 1];
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int i = 0; i <= N; ++i) {
                list.add(new ArrayList<>());
            }

            time = new int[N + 1];

            while (K-- > 0) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
                time[end]++;
            }

            int W = Integer.parseInt(in.readLine());

            sb.append(DP(W)).append("\n");
        }

        System.out.println(sb);
    }

    static int DP(int W) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            result[i] = arr[i];

            if (time[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int num : list.get(now)) {
                result[num] = Math.max(result[num], result[now] + arr[num]);
                time[num]--;

                if (time[num] == 0) {
                    q.offer(num);
                }
            }
        }

        return result[W];
    }
}
