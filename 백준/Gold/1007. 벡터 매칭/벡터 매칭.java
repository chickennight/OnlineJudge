import java.util.*;
import java.io.*;

public class Main {

	static double ans;
	static boolean[] visit;
	static int[][] Point;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			ans = Double.MAX_VALUE;

			visit = new boolean[N];

			Point = new int[N][2];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());

				Point[j][0] = Integer.parseInt(st.nextToken());
				Point[j][1] = Integer.parseInt(st.nextToken());
			}

			combination(0, N / 2);

			System.out.println(ans);
		}
	}

	static void combination(int index, int count) {
		if (count == 0) {
			ans = Math.min(ans, vector());
		} else {
			for (int i = index; i < Point.length; i++) {

				visit[i] = true;
				combination(i + 1, count - 1);
				visit[i] = false;
			}
		}
	}

	static double vector() {
		int x = 0;
		int y = 0;

		for (int i = 0; i < Point.length; i++) {
			if (visit[i]) {
				x += Point[i][0];
				y += Point[i][1];
			}

			else {
				x -= Point[i][0];
				y -= Point[i][1];
			}
		}

		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

}