import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int destination, distance, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; ++i)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        bfs();
        System.out.println(destination + " " + distance + " " + cnt);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.offer(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int now = arr[0];
            int next = arr[1];

            if (next > distance) {
                distance = next;
                destination = now;
                cnt = 1;
            } else if (next == distance) {
                if (destination > now) destination = now;
                cnt++;
            }

            for (int i = 0; i < list[now].size(); ++i) {
                int nextPoint = list[now].get(i);
                if (!visited[nextPoint]) {
                    visited[nextPoint] = true;
                    q.offer(new int[]{nextPoint, next + 1});
                }
            }
        }
    }

}