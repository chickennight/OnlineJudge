import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int[] c = new int[s.length()];
        int n = 0;
        for (int i = 0 ; i < s.length(); ++i) 
            c[i] = s.charAt(i) - '0';
        
        for (int i = 0 ; i < c.length; ++i) 
            n += Math.pow(c[i], 5);
        
        System.out.println(n);
    }
}