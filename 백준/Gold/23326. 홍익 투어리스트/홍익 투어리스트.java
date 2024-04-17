import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int pos = 1;

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; ++i)
            if (Integer.parseInt(st.nextToken()) == 1)
                set.add(i);

        int num;
        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(in.readLine());
            num = Integer.parseInt(st.nextToken());

            if (num == 1) {

                int idx = Integer.parseInt(st.nextToken());

                if (set.contains(idx)) {
                    set.remove(idx);
                } else {
                    set.add(idx);
                }

            } else if (num == 2) {
                
                int move = Integer.parseInt(st.nextToken()) % N;
                pos += move;

                if (pos > N)
                    pos %= N;


            } else {
                
                if (set.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }

                if (set.contains(pos)) {
                    sb.append(0).append("\n");
                    continue;
                }

                Integer front = set.higher(pos);
                Integer back = set.higher(0);

                if (front != null) {
                    sb.append(front - pos).append("\n");
                } else {
                    sb.append(N - pos + back).append("\n");
                }
                
            }
        }
        System.out.println(sb);
    }

}