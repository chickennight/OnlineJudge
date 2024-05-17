import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] arr = new int[3][N];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            adj.add(new ArrayList<>());

        Map<Integer, Integer>[] numCnt = new HashMap[3];
        StringTokenizer st;
        for (int i = 0; i < 3; ++i) {
            numCnt[i] = new HashMap<>();
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
                adj.get(arr[i][j]).add(j);
                numCnt[i].put(arr[i][j], numCnt[i].getOrDefault(arr[i][j], 0) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            if (numCnt[1].getOrDefault(i, 0) == 0 || numCnt[2].getOrDefault(i, 0) == 0) {
                q.add(i);
            }
        }

        boolean[] visited = new boolean[N];
        int cnt = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : adj.get(now)) {

                if (visited[next])
                    continue;

                visited[next] = true;
                cnt++;

                for (int i = 0; i < 3; ++i) {
                    int num = arr[i][next];
                    numCnt[i].put(num, numCnt[i].get(num) - 1);
                    if (numCnt[i].get(num) == 0)
                        q.add(num);
                }
            }
        }

        System.out.println(cnt);
    }
}
