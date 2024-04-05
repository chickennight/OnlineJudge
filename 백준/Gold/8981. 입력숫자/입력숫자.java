import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[N];
        int value = 0, from = 0, num;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            num = Integer.parseInt(st.nextToken());

            from = (from + value) % N;
            value = arr[from];
            while (value > 0) {
                from = (from + 1) % N;
                value = arr[from];
            }

            arr[from] = num;
            value = num;
        }

        out.write(N + "\n");
        for (int i = 0; i < N; ++i)
            out.write(arr[i] + " ");


        out.flush();
        out.close();
        in.close();
    }

}