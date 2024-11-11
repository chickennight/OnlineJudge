import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());


        for (int i = 0; i < R; ++i) {
            String S = in.readLine();
            list.add(S);
        }
        int x = C * ZC / list.get(0).length();
        int y = R * ZR / list.size();

        for (String s : list) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < list.get(0).length(); ++j) {
                str.append(String.valueOf(s.charAt(j)).repeat(Math.max(0, x)));
            }
            for (int k = 0; k < y; ++k) {
                System.out.println(str);
            }
        }
    }
}