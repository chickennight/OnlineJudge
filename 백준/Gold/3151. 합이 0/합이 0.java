import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            data[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(data);
        long ans = 0L;
        for (int i = 0; i < N; ++i) {
            if (data[i] > 0) break;
            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                int s = 1;
                int e = 1;
                int now = data[i] + data[start] + data[end];
                if (now == 0) {
                    if (data[start] == data[end]) {
                        ans += (long) (end - start + 1) * (end - start) / 2;
                        break;
                    }
                    while (start + 1 < end && data[start] == data[start + 1]) {
                        s++;
                        start++;
                    }
                    while (start < end - 1 && data[end] == data[end - 1]) {
                        e++;
                        end--;
                    }

                    ans += (long) s * e;
                }

                if (now > 0)
                    end--;
                else start++;
            }
        }
        System.out.println(ans);
    }
}
