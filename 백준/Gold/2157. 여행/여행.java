import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int index;
        int score;

        public Node(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][N + 1];

        List<Node>[] boards = new List[N + 1];

        for (int i = 0; i <= N; ++i)
            boards[i] = new ArrayList<>();

        for (int i = 0; i < K; ++i) {

            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b)
                continue;

            boards[a].add(new Node(b, c));
        }

        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        int cnt = 1, size, now, nIdx, nScore;
        while (!q.isEmpty() && cnt < M) {
            size = q.size();
            while (size-- > 0) {
                now = q.poll();
                for (Node next : boards[now]) {

                    nIdx = next.index;
                    nScore = dp[cnt][now] + next.score;

                    if (dp[cnt + 1][nIdx] >= nScore)
                        continue;

                    dp[cnt + 1][nIdx] = nScore;
                    q.add(nIdx);

                }
            }
            cnt++;
        }

        for (int i = 2; i <= M; ++i)
            answer = Integer.max(answer, dp[i][N]);

        System.out.println(answer);
    }

}