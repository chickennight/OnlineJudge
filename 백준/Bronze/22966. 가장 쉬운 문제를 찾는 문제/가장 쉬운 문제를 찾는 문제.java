import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        String answer = "";
        int level = Integer.MAX_VALUE;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String problem = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if (x < level) {
                answer = problem;
                level = x;
            }
        }
        System.out.println(answer);
    }
}