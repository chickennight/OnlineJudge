import java.util.*;
import java.io.*;

public class Main {
    private static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) 
            list.add(Integer.parseInt(st.nextToken()));

        max = Integer.MIN_VALUE;
        charge(list,0);
        System.out.print(max);
    }
    private static void charge(List<Integer> list, int sum) {
        if (list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < list.size() - 1; ++i) {
            int tmp = list.get(i);
            int value = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            charge(list, sum + value);
            list.add(i, tmp);
        }
    }
}