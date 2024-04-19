import java.io.*;
 
import java.util.StringTokenizer;
 
import java.math.BigDecimal;
 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
 
        BigDecimal A = new BigDecimal(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A.pow(B).toPlainString());
    }
}