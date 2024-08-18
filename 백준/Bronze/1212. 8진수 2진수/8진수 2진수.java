import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            String a = Integer.toBinaryString(s.charAt(i) - '0');
            if (a.length() == 2 && i != 0)
                a = "0" + a;
            else if (a.length() == 1 && i != 0)
                a = "00" + a;

            sb.append(a);
        }

        System.out.println(sb);
    }

}
