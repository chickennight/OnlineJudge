import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; ++i)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        int result = twoPointer(N, numbers);
        System.out.println(result);
    }

    private static int twoPointer(int N, int[] numbers) {
        int result = 0, left, right;
        for (int i = 0; i < N; ++i) {
            left = 0;
            right = N - 1;

            while (true) {
                if (left == i) left++;
                else if (right == i) right--;

                if (left >= right) break;

                if (numbers[left] + numbers[right] > numbers[i]) right--;
                else if (numbers[left] + numbers[right] < numbers[i]) left++;
                else {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

}