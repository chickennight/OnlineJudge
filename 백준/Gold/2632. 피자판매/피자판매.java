import java.util.*;
import java.io.*;

public class Main {

    static int size, m, n;
    static int[] A, B, sumA, sumB, cntA, cntB;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        A = new int[m * 2 + 1];
        for (int i = 1; i <= m; ++i) {
            A[i] = Integer.parseInt(in.readLine());
            A[i + m] = A[i];
        }

        B = new int[n * 2 + 1];
        for (int i = 1; i <= n; ++i) {
            B[i] = Integer.parseInt(in.readLine());
            B[i + n] = B[i];
        }

        sumA = new int[m * 2 + 1];
        sumA[1] = A[1];
        for (int i = 2; i <= m * 2; ++i)
            sumA[i] = A[i] + sumA[i - 1];


        sumB = new int[n * 2 + 1];
        sumB[1] = B[1];
        for (int i = 2; i <= n * 2; ++i)
            sumB[i] = B[i] + sumB[i - 1];


        cntA = new int[size + 1];
        cntB = new int[size + 1];
        makeArr(cntA, sumA, m);
        makeArr(cntB, sumB, n);

        int answer = 0;
        answer += cntA[size];
        answer += cntB[size];
        for (int i = 1; i < size; ++i) {
            int a = i;
            int b = size - i;
            answer += cntA[a] * cntB[b];
        }

        System.out.println(answer);
    }

    public static void makeArr(int[] arr, int[] sum, int max) {
        for (int i = 1; i < max; ++i) {
            for (int j = 1; j <= max; ++j) {
                int value = sum[j + i - 1] - sum[j - 1];
                if (value > size)
                    continue;
                arr[value]++;
            }
        }

        if (sum[max] <= size)
            arr[sum[max]]++;
    }
}