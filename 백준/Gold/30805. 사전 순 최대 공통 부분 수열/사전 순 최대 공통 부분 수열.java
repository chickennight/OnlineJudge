import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<Integer> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            a.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(in.readLine());
        List<Integer> b = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; ++i)
            b.add(Integer.parseInt(st.nextToken()));

        boolean tf = true;
        List<Integer> ans = new ArrayList<>();

        while (true) {
            while (true) {
                if (a.isEmpty() || b.isEmpty()) {
                    tf = false;
                    break;
                }

                int maxA = Collections.max(a);
                int aIdx = a.indexOf(maxA);
                int maxB = Collections.max(b);
                int bIdx = b.indexOf(maxB);

                if (maxA == maxB) break;
                else if (maxA > maxB) a.remove(aIdx);
                else b.remove(bIdx);
            }
            if (!tf) break;

            ans.add(Collections.max(a));

            a.subList(0, a.indexOf(Collections.max(a)) + 1).clear();
            b.subList(0, b.indexOf(Collections.max(b)) + 1).clear();
        }

        StringBuilder sb = new StringBuilder();
        if (!ans.isEmpty()) {
            sb.append(ans.size()).append('\n');
            for (int v : ans)
                sb.append(v).append(" ");

        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }

}