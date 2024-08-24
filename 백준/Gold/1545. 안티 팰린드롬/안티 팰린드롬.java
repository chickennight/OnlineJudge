import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] s = in.readLine().toCharArray();
        Arrays.sort(s);
        int n = s.length;
        int i = n / 2 - 1;
        int j = i + 1;

        if (n % 2 != 0)
            j++;

        while (j < n) {
            int x = j;
            while (s[i] == s[x]) {
                x++;
                if (x == n) {
                    System.out.println(-1);
                    return;
                }
            }
            char temp = s[j];
            s[j] = s[x];
            s[x] = temp;
            i--;
            j++;
        }

        System.out.println(new String(s));
    }

}
