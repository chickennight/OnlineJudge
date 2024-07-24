import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String[] inputs = in.readLine().split(" ");

            int n = Integer.parseInt(inputs[0]);

            int[] arr = new int[n];
            long answer = 0;

            for (int i = 0; i < arr.length; ++i) {
                arr[i] = Integer.parseInt(inputs[i + 1]);
            }

            for (int i = 0; i < arr.length - 1; ++i) {
                for (int j = i + 1; j < arr.length; ++j) {
                    answer += gcd(arr[i], arr[j]);
                }
            }
            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}