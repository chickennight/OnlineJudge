import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int num;
		int x;
		int y;
		int z;

		Point(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start, end;
		long leng;

		public Edge(int start, int end, long leng) {
			super();
			this.start = start;
			this.end = end;
			this.leng = leng;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.leng, o.leng);
		}

	}

	static int[] parent;
	static ArrayList<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());

		Point[] points = new Point[N];
		parent = new int[N];
		for (int i = 1; i < N; ++i)
			parent[i] = i;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			points[i] = new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		edges = new ArrayList<>();

		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);

			edges.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);

			edges.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);

			edges.add(new Edge(points[i].num, points[i + 1].num, weight));
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		Collections.sort(edges);

		long ans = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);

			if (findset(edge.start) != findset(edge.end)) {
				ans += edge.leng;
				union(edge.start, edge.end);
			}
		}

		System.out.println(ans);

	}

	static int findset(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findset(parent[x]);
	}

	static void union(int x, int y) {
		x = findset(x);
		y = findset(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}