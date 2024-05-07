import java.util.*;
import java.io.*;

class Solution {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, w, h;
	static int min;

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int[][] origin = new int[h][w];
			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < w; ++j) {
					origin[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			play(origin, 0);
			if (min == Integer.MAX_VALUE)
				min = 0;
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void play(int[][] origin, int depth) {
		if (depth >= N) {
			min = Math.min(min, count(origin));
		} else {
			for (int j = 0; j < w; ++j) {
				int y = -1;
				for (int i = 0; i < h; ++i) {
					if (origin[i][j] != 0) {
						y = i;
						break;
					}
				}

				if (y != -1) {
					int[][] map = new int[h][w];

					for (int i = 0; i < h; ++i)
						map[i] = origin[i].clone();

					bomb(map, y, j);
					nextMap(map);
					play(map, depth + 1);
				}
			}
		}
	}

	static void bomb(int[][] map, int y, int x) {
		int power = map[y][x];
		map[y][x] = 0;
		for (int i = 1; i < power; ++i) {
			for (int j = 0; j < 4; ++j) {
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;
				if (inRange(nx, ny) && map[ny][nx] != 0) {
					bomb(map, ny, nx);
				}
			}
		}
	}

	static void nextMap(int[][] map) {
		for (int j = 0; j < w; ++j) {
			for (int i = h - 1; i > 0; --i) {
				if (map[i][j] == 0) {
					for (int k = i - 1; k >= 0; --k) {
						if (map[k][j] != 0) {
							int temp = map[k][j];
							map[k][j] = 0;
							map[i][j] = temp;
							break;
						}
					}
				}
			}
		}
	}

	static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
}