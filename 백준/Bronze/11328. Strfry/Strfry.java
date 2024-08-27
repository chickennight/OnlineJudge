import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] alphaA = new int[26];
        int[] alphaB = new int[26];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        loop:
        while (N-- > 0) {
            st = new StringTokenizer(in.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.length() != B.length()) {
                sb.append("Impossible").append('\n');
                continue;
            }

            Arrays.fill(alphaA, 0);
            Arrays.fill(alphaB, 0);

            for (int i = 0; i < A.length(); ++i)
                alphaA[A.charAt(i) - 'a']++;

            for (int i = 0; i < B.length(); ++i)
                alphaB[B.charAt(i) - 'a']++;


            for (int i = 0; i < 26; ++i) {
                if (alphaA[i] != alphaB[i]) {
                    sb.append("Impossible").append('\n');
                    continue loop;
                }
            }

            sb.append("Possible").append('\n');
        }

        System.out.println(sb);
    }
}
