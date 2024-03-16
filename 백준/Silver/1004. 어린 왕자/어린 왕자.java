import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int i=0; i<T; i++) {
            int count = 0;
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(in.readLine());
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(in.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                count += pass(x1,y1,x2,y2,cx,cy,r);
            }
            sb.append(count).append("\n");
        }


        System.out.println(sb);
    }

    public static int pass(int x1, int y1, int x2, int y2, int cx, int cy, int r){
        double star1 = Math.sqrt(Math.pow(x1-cx,2)+Math.pow(y1-cy,2));
        double star2 = Math.sqrt(Math.pow(x2-cx,2)+Math.pow(y2-cy,2));
        if(r>star1 && r>star2){
            return 0;
        }else if(r<star1 && r<star2){
            return 0;
        }else {
            return 1;
        }
    }
}