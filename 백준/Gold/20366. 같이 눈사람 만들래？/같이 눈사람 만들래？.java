import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        twoPoint();

        System.out.println(ans);
    }

    private static void twoPoint() {
        for (int i = 0; i <= N - 4; ++i) {
            for (int j = N - 1; j >= i + 3; --j) {
                int snowman1 = arr[i] + arr[j];
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int snowman2 = arr[left] + arr[right];
                    if (snowman2 < snowman1) {
                        left++;
                    } else if (snowman2 > snowman1) {
                        right--;
                    } else {
                        ans = 0;
                        return;
                    }
                    ans = Math.min(ans, Math.abs(snowman1 - snowman2));
                }
            }
        }
    }

}