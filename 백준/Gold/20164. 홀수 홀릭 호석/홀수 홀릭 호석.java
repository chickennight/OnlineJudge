import java.io.*;

public class Main {
    private static int min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        calculate(n, 0);

        System.out.println(min + " " + max);

    }

    private static void calculate(int n, int cnt) {
        cnt += cntOdd(n);

        if (n / 10 == 0) {
            min = Integer.min(min, cnt);
            max = Integer.max(max, cnt);
        } else if (n / 100 == 0) {
            int next = n / 10;
            next += n % 10;
            calculate(next, cnt);
        } else {
            String str = String.valueOf(n);
            for (int i = 0; i < str.length() - 2; ++i) {
                for (int j = i + 1; j < str.length() - 1; ++j) {
                    int next = Integer.parseInt(str.substring(0, i + 1));
                    next += Integer.parseInt(str.substring(i + 1, j + 1));
                    next += Integer.parseInt(str.substring(j + 1));

                    calculate(next, cnt);
                }
            }
        }
    }

    private static int cntOdd(int n) {
        int cnt = 0;
        while (n > 0) {
            int tmp = n % 10;
            if (tmp % 2 == 1) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}