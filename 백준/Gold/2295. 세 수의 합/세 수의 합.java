import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[N];
        while (N-- > 0) {
            numbers[N] = Integer.parseInt(in.readLine());
        }

        int[] tempSum = new int[(numbers.length * (numbers.length + 1)) / 2];
        int count = 0;
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i; j < numbers.length; ++j) {
                tempSum[count++] = numbers[i] + numbers[j];
            }
        }

        Arrays.sort(tempSum);

        int answer = -1;
        for (int i : numbers) {
            for (int j : numbers) {
                if (binarySearch(tempSum, i - j)) {
                    answer = Math.max(answer, i);
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > target) {
                r = m - 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}