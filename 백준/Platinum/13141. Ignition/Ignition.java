import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long dist;

		public Edge(int from, int to, long dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}

	static int[][] map;
	static int N, M;
	static long[] d;
	static List<List<Edge>> graph;
	static List<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<Edge>());
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		edges = new ArrayList<>();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			edges.add(new Edge(S, E, L));
			graph.get(S).add(new Edge(S, E, L));
			graph.get(E).add(new Edge(E, S, L));
			map[S][E] = Math.min(map[S][E], L);
			map[E][S] = Math.min(map[E][S], L);
		}

		floyd(map);
		double ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; ++i) {
			dijkstra(i);
			double temp = calc();
			ans = Math.min(ans, temp);
		}
		System.out.println(ans);
	}

	static void floyd(int[][] dist) {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}

	static void dijkstra(int start) {
		d = new long[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (d[now.to] < now.dist)
				continue;
			for (Edge next : graph.get(now.to)) {
				if (d[next.to] > now.dist + next.dist) {
					d[next.to] = now.dist + next.dist;
					pq.offer(new Edge(now.to, next.to, now.dist + next.dist));
				}
			}
		}
	}

	static double calc() {
		double ret = 0;
		for (Edge e : edges) {
			double temp = ((double) (e.dist + d[e.from] + d[e.to]) / 2);
			if (ret < temp)
				ret = temp;
		}
		return ret;
	}
}