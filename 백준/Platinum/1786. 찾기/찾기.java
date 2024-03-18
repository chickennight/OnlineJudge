import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static char[] T, P;
	static int[] pi;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = in.readLine().toCharArray();
		P = in.readLine().toCharArray();

		pi = new int[P.length];
		getPi();

		sb = new StringBuilder();
		ans = 0;
		KMP();
		System.out.println(ans);
		System.out.println(sb);

	}

	static void getPi() {
		int j = 0;
		for (int i = 1; i < P.length; ++i) {
			while (j > 0 && P[i] != P[j])
				j = pi[j - 1];
			if (P[i] == P[j])
				pi[i] = ++j;
		}
	}

	static void KMP() {
		int j = 0;
		for (int i = 0; i < T.length; ++i) {
			while (j > 0 && T[i] != P[j])
				j = pi[j - 1];
			if (T[i] == P[j])
				if (j == P.length - 1) {
					j = pi[j];
					ans++;
					sb.append(i - P.length + 2).append(" ");
				} else
					j++;
		}
	}
}
