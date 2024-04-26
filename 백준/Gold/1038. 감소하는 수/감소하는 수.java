import java.util.*;
import java.io.*;

public class Main {

    private static ArrayList<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        list = new ArrayList<>();

        if (n <= 10) System.out.println(n);
        else if (n > 1022) System.out.println("-1");
        else {

            for (int i = 0; i < 10; ++i)
                dp(i, 1);
            
            Collections.sort(list);

            System.out.println(list.get(n));
        }
    }

    public static void dp(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; ++i)
            dp((num * 10) + i, idx + 1);

    }
}