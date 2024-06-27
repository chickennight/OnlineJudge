import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (op.equals("E")) break;
            sb.append(String.format("Case %d: %s\n", tc++, getResult(a, b, op) ? "true" : "false"));
        }
        System.out.print(sb);
    }

    private static boolean getResult(int a, int b, String op) {
        switch (op) {
            case ">":
                return a > b;
            case ">=":
                return a >= b;
            case "<":
                return a < b;
            case "<=":
                return a <= b;
            case "==":
                return a == b;
            case "!=":
                return a != b;
        }
        return false;
    }
}