import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c =0;
            if(b%4==0) {
                c = (int) Math.pow(a,4)%10;
            }else {
                c = (int) Math.pow(a,b%4)%10;
            }

            if(c==0) {
                sb.append(10).append("\n");
            }else {
                sb.append(c).append("\n");
            }
        }

        System.out.println(sb);
    }
}