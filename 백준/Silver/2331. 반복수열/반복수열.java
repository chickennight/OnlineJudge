import java.util.*;
import java.io.*;

public class Main {
    private static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        while (!map.containsKey(A)) {
            map.put(A, ++idx);
            A = nextNum(A);
        }
        System.out.println(map.get(A) - 1);
    }

    private static int nextNum(int val) {
        int temp = 0;
        while (val > 0) {
            temp += (int) Math.pow((val % 10), P);
            val /= 10;
        }
        return temp;
    }

}