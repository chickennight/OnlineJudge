import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            ans = (ans + Integer.parseInt(st.nextToken())) % 3;

        System.out.println(ans == 0 ? "yes" : "no");
    }
}