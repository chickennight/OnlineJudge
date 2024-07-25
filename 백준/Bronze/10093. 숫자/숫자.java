import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }
        if (A == B)
            sb.append(0).append("\n");
        else sb.append(B - A - 1).append("\n");
        
        for (long i = A + 1; i < B; ++i)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}