import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = N - 1;
        int min = Integer.MAX_VALUE;

        while (l < r) {

            int sum = arr[l] + arr[r];

            if (Math.abs(sum) <= Math.abs(min))
                min = sum;

            if (sum < 0)
                l++;
            else
                r--;
            
        }
        System.out.println(min);
    }
}