import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long ans = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j) 
                ans += Math.abs(arr[i] - arr[j]);
        System.out.println(ans * 2);
    }
}