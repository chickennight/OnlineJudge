import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		String[] arr = new String[k];
		int maxLen = 0;
		for (int i = 0; i < k; ++i) {
			arr[i] = in.readLine();
			maxLen = Math.max(maxLen, arr[i].length());
		}

		Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

		StringBuilder sb = new StringBuilder();
		boolean tf = true;
		for (int i = 0; i < k; ++i) {
			if (tf && arr[i].length() == maxLen) {
				tf = false;
				for (int j = 0; j < n - k + 1; ++j)
					sb.append(arr[i]);
			} else
				sb.append(arr[i]);

		}
		System.out.println(sb);
	}
}
