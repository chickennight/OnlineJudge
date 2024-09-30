import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String vega = "(100+1+|01)+";
        int t = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            String message = in.readLine();
            if (message.matches(vega)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

}