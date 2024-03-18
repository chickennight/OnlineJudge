import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { 0, 0 });
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int temp = 1;
			while (temp <= K) {
				list.add(new int[] { temp * V, temp * C });
				K -= temp;
				temp *= 2;
			}

			if (K != 0)
				list.add(new int[] { K * V, K * C });

		}

		int S = list.size();
		int[][] dp = new int[S + 1][M + 1];
		for (int i = 1; i < S; ++i) {
			int weight = list.get(i)[0];
			int value = list.get(i)[1];
			for (int j = 1; j <= M; ++j) {
				if (j < weight)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
			}
		}

		System.out.println(dp[S - 1][M]);
	}

}
