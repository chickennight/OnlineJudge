import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] aArr = new int[10];
        int[] bArr = new int[10];

        for (int i = 0; i < 10; ++i)
            aArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; ++i)
            bArr[i] = Integer.parseInt(st.nextToken());

        int aCount = 0, bCount = 0;

        for (int i = 0; i < 10; ++i) {
            if (aArr[i] > bArr[i])
                aCount++;
            else if (aArr[i] < bArr[i])
                bCount++;
        }

        if (aCount == bCount)
            System.out.println("D");
        else if (aCount > bCount)
            System.out.println("A");
        else
            System.out.println("B");
        
    }

}
