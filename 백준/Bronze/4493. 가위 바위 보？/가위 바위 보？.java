import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(in.readLine());
            int p1Win = 0;
            int p2Win = 0;

            StringTokenizer st;
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(in.readLine());

                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (p1.equals("R") && p2.equals("S") || p1.equals("S") && p2.equals("P") || p1.equals("P") && p2.equals("R"))
                    p1Win++;
                else if (p2.equals("R") && p1.equals("S") || p2.equals("S") && p1.equals("P") || p2.equals("P") && p1.equals("R"))
                   p2Win++;
                
            }

            if (p1Win > p2Win)
                System.out.println("Player 1");
            else if (p1Win < p2Win)
                System.out.println("Player 2");
            else
                System.out.println("TIE");
            
        }
    }
}