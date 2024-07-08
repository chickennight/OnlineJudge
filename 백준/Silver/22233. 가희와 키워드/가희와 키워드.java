import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        while (N-- > 0)
            set.add(in.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(in.readLine(), ",");
            while (st.hasMoreTokens()) {
                String keyword = st.nextToken();
                set.remove(keyword);
            }
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}