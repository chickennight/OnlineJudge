import java.io.*;

public class Main {

    public static int N;
    public static char[][] sign;
    public static int[] result;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        sign = new char[N][N];
        result = new int[N];
        String S = in.readLine();

        int idx = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                sign[i][j] = S.charAt(idx++);
            }
        }
        guess(0);
    }

    public static void guess(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; ++i)
                System.out.print(result[i] + " ");

            System.exit(0);
        }

        for (int i = -10; i <= 10; ++i) {
            result[depth] = i;

            if (signCheck(depth))
                guess(depth + 1);
        }
    }

    public static boolean signCheck(int depth) {
        int temp = 0;

        for (int i = 0; i < depth + 1; ++i)
            temp += result[i];

        for (int i = 0; i < depth + 1; ++i) {
            if ((temp > 0 && sign[i][depth] != '+') || (temp == 0 && sign[i][depth] != '0') || (temp < 0 && sign[i][depth] != '-'))
                return false;
            
            temp -= result[i];
        }
        return true;
    }
}
