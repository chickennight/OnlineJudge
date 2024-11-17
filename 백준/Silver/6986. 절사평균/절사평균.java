import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        double[] arr = new double[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = Double.parseDouble(in.readLine());
        }
        Arrays.sort(arr);
        double sum = 0.0;
        for (int i = k; i < n - k; ++i) {
            sum += arr[i];
        }
        System.out.printf("%.2f%n", sum / (n - k * 2) + 1e-8);
        for (int i = 0; i < k; ++i) {
            sum += arr[k];
            sum += arr[n - k - 1];
        }
        System.out.printf("%.2f%n", sum / n + 1e-8);
    }

}