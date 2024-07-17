import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Alpha[] alphas = new Alpha[10];
        for (int i = 0; i < 10; i++) {
            alphas[i] = new Alpha();
        }

        for (int i = 0; i < N; ++i) {
            String str = in.readLine();
            alphas[str.charAt(0) - 'A'].num += (long) Math.pow(10, str.length() - 1);
            alphas[str.charAt(0) - 'A'].start = true;
            for (int j = 1; j < str.length(); ++j) {
                alphas[str.charAt(j) - 'A'].num += (long) Math.pow(10, str.length() - j - 1);
            }
        }

        boolean[] used = new boolean[10];
        long sum = 0;

        Arrays.sort(alphas);

        for (int i = 0; i < 10; ++i) {
            if (alphas[i].start) {
                for (int j = 1; j <= 9; ++j) {
                    if (!used[j]) {
                        used[j] = true;
                        sum += alphas[i].num * (long) j;
                        break;
                    }
                }
            } else {
                for (int j = 0; j <= 9; ++j) {
                    if (!used[j]) {
                        used[j] = true;
                        sum += alphas[i].num * (long) j;
                        break;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}

class Alpha implements Comparable<Alpha> {
    long num = 0;
    boolean start = false;

    @Override
    public int compareTo(Alpha o) {
        return Long.compare(num, o.num);
    }
}