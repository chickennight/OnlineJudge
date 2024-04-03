import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        String str;
        StringBuilder temp;

        while (n > 0) {
            while (st.hasMoreTokens()) {
                str = st.nextToken();
                temp = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; --i) {
                    temp.append(str.charAt(i));
                }
                arr[--n] = Long.parseLong(temp.toString());
            }
            if (n > 0)
                st = new StringTokenizer(in.readLine());
        }
        
        Arrays.sort(arr);
        for (long l : arr)
            out.write(l + "\n");

        out.flush();
    }
}