import java.util.*;
import java.io.*;

public class Main {
    static char[] input;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        input = st.nextToken().toCharArray();
        length = input.length;
        int k = Integer.parseInt(st.nextToken());

        System.out.println((long) length * k - (long) solve() * (k - 1));
    }

    public static int solve() {
        int[] fail = new int[length];

        for (int i = 1; i < length; ++i) {
            int j = fail[i - 1];
            while (j > 0 && input[j] != input[i]) j = fail[j - 1];
            if (input[i] == input[j]) fail[i] = j + 1;
        }

        return fail[length - 1];
    }
}
