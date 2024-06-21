import java.io.*;

public class Main {

    static int K, N;
    static char[][] map;
    static int blankLine;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(in.readLine());
        N = Integer.parseInt(in.readLine());

        char[] origin = new char[K];
        for (int i = 0; i < K; ++i)
            origin[i] = (char) ('A' + i);

        char[] result = in.readLine().toCharArray();

        map = new char[N][K - 1];

        for (int i = 0; i < N; ++i) {
            String input = in.readLine();

            if (input.charAt(0) == '?') {
                blankLine = i;
                continue;
            }
            map[i] = input.toCharArray();
        }

        for (int i = 0; i < blankLine; ++i)
            ladder(origin, i);

        for (int i = N - 1; i > blankLine; --i)
            ladder(result, i);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K - 1; ++i) {
            if (origin[i] == result[i]) {
                sb.append("*");
            } else if (origin[i] == result[i + 1]) {
                sb.append("-");
                char temp = origin[i];
                origin[i] = origin[i + 1];
                origin[i + 1] = temp;
            } else {
                sb = new StringBuilder();
                sb.append("x".repeat(K - 1));
                break;
            }
        }

        System.out.print(sb);
    }

    private static void ladder(char[] origin, int i) {
        for (int j = 0; j < K - 1; ++j) {
            if (map[i][j] == '-') {
                char tmpChar = origin[j];
                origin[j] = origin[j + 1];
                origin[j + 1] = tmpChar;
            }
        }
    }

}