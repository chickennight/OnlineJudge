import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			while (!dq.isEmpty() && data[dq.getLast()] > data[i])
				dq.removeLast();
			dq.addLast(i);
			if (!dq.isEmpty() && dq.getFirst() <= i - L)
				dq.removeFirst();
			sb.append(data[dq.getFirst()]).append(" ");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
