import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        int[] cntArr = new int[2000001];
        for (int i = 0; i < N; ++i)
            cntArr[Integer.parseInt(in.readLine()) + 1000000]++;

        in.close();

        for (int i = 0; i <= 2000000; ++i) {
            for (int j = 0; j < cntArr[i]; ++j) {
                sb.append(i - 1000000).append("\n");
            }
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}