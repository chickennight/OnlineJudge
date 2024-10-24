import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (b <= 59) {
                System.out.println(name + " " + "F");
            } else if (b <= 66) {
                System.out.println(name + " " + "D");
            } else if (b <= 69) {
                System.out.println(name + " " + "D+");
            } else if (b <= 76) {
                System.out.println(name + " " + "C");
            } else if (b <= 79) {
                System.out.println(name + " " + "C+");
            } else if (b <= 86) {
                System.out.println(name + " " + "B");
            } else if (b <= 89) {
                System.out.println(name + " " + "B+");
            } else if (b <= 96) {
                System.out.println(name + " " + "A");
            } else if (b <= 100) {
                System.out.println(name + " " + "A+");
            }

        }
    }
}