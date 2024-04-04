import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(in.readLine());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for (int i = 0; i <= N; ++i)
            a.add(new ArrayList<>());

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(in.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; ++j) {
                int temp = Integer.parseInt(st.nextToken());
                a.get(temp).add(i);

                indegree[i]++;
            }
        }

        out.write(topologicalSort(N, a, indegree, time) + "\n");
        out.flush();
        out.close();
        in.close();
    }

    public static int topologicalSort(int N, ArrayList<ArrayList<Integer>> a, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            result[i] = time[i];

            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : a.get(now)) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[now] + time[next]);

                if (indegree[next] == 0)
                    q.offer(next);

            }
        }

        int ans = 0;
        for (int i = 1; i <= N; ++i)
            ans = Math.max(ans, result[i]);

        return ans;
    }

}