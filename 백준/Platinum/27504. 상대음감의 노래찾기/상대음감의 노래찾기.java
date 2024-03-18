import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		HashMap<Integer, int[]> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int size = Integer.parseInt(st.nextToken());
			int[] temp = new int[size];
			for (int j = 0; j < size; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			map.put(i, temp);
		}

		int melodySize = Integer.parseInt(in.readLine());
		int[] melodyTemp = new int[melodySize];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < melodySize; i++) {
			melodyTemp[i] = Integer.parseInt(st.nextToken());
		}
		int[] melody = new int[melodySize];
		melody[0] = melodyTemp[0] - melodyTemp[melodySize - 1];
		for (int i = 1; i < melodySize; i++) {
			melody[i] = melodyTemp[i] - melodyTemp[i - 1];
		}

		int cnt = 0;
		for (int t = 1; t <= N; t++) {
			int[] arr = map.get(t);
			if (arr.length >= melodySize) {
				for (int i = 0; i <= arr.length - melodySize; i++) {
					if (melody[0] != arr[i] - arr[i - 1 + melodySize]) {
						continue;
					}
					boolean tf = true;
					for (int j = 1; j < melodySize; j++) {
						if (arr[i + j] - arr[i + j - 1] != melody[j]) {
							tf = false;
							break;
						}
					}
					if (tf) {
						cnt++;
						sb.append(t).append(" ");
						break;
					}
				}
			}
		}
		if (cnt == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}

}