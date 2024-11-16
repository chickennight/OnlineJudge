import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();
        int ans = 0;

        for (int i = 0; i < str.length(); ++i) {
            String sub = str.substring(i);
            ans = Math.max(ans, getSubLength(sub));
        }

        System.out.print(ans);
    }

    private static int getSubLength(String str) {
        int j = 0;
        int n = str.length(), max = 0;
        int[] pi = new int[n];

        for (int i = 1; i < n; ++i) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }

        return max;
    }

}