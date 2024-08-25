import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet())
            sb.append(s).append(" ").append(map.get(s)).append("\n");

        System.out.println(sb);
    }

}
