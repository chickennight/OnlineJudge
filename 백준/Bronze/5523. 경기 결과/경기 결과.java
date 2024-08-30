import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(in.readLine());
        int cntA = 0;
        int cntB = 0;

        for (int i = 0; i < num; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int scoreA = Integer.parseInt(st.nextToken());
            int scoreB = Integer.parseInt(st.nextToken());

            if (scoreA > scoreB)
                cntA++;
            else if (scoreA < scoreB)
                cntB++;

        }

        sb.append(cntA).append(" ").append(cntB);
        System.out.println(sb);
    }

}
