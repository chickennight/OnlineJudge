import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;

        while (true) {
            int n = Integer.parseInt(in.readLine());
            
            if (n == 0) 
                break;

            if (n % 2 == 0) {
                n = (((n * 3) / 2) * 3) / 9;
                System.out.println(cnt + ". even " + n);
            } else {
                n = ((((n * 3) + 1) / 2) * 3) / 9;
                System.out.println(cnt + ". odd " + n);
            }
            
            cnt++;
        }
    }
}