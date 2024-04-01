import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
 
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String[] number = new String[N];
 
            for (int i = 0; i < N; ++i)
                number[i] = in.readLine();
            
            Arrays.sort(number);
 
            if (isConsistent(N, number)) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
            }
        }
 
        out.flush();
        out.close();
        in.close();
    }
 
    public static boolean isConsistent(int N, String[] number) {
        for (int i = 0; i < N - 1; ++i) {
            if (number[i + 1].startsWith(number[i])) {
                return false;
            }
        }
        return true;
    }
 
}