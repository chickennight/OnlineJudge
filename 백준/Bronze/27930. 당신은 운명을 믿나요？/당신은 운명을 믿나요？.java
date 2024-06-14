import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String L = in.readLine();

        boolean[] Y = new boolean[6];
        boolean[] K = new boolean[5];
        for (int i = 0; i < L.length(); ++i) {
            char c = L.charAt(i);
            switch (c) {
                case 'Y':
                    if (!Y[0]) Y[0] = true;
                    break;
                case 'K':
                    if (!K[0]) K[0] = true;
                    break;
                case 'O':
                    if (Y[0] && !Y[1]) Y[1] = true;
                    if (K[0] && !K[1]) K[1] = true;
                    break;
                case 'N':
                    if (Y[1] && !Y[2]) Y[2] = true;
                    break;
                case 'S':
                    if (Y[2] && !Y[3]) Y[3] = true;
                    break;
                case 'E':
                    if (Y[3] && !Y[4]) Y[4] = true;
                    if (K[2] && !K[3]) K[3] = true;
                    break;
                case 'I':
                    if (Y[4] && !Y[5]) Y[5] = true;
                    break;
                case 'R':
                    if (K[1] && !K[2]) K[2] = true;
                    break;
                case 'A':
                    if (K[3] && !K[4]) K[4] = true;
                    break;
            }
            if (Y[5]) {
                System.out.println("YONSEI");
                break;
            }
            if (K[4]) {
                System.out.println("KOREA");
                break;
            }
        }
    }
}
