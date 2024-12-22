import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine(), ",");
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] newArr = Arrays.copyOf(arr, arr.length);
        int arrLength = N - 1;

        while (K != 0) {
            int[] moveArr = new int[arrLength];

            for (int i = 0; i < newArr.length - 1; ++i) {
                moveArr[i] = newArr[i + 1] - newArr[i];
            }

            arrLength--;
            K--;
            newArr = Arrays.copyOf(moveArr, moveArr.length);
        }

        for (int i = 0; i < newArr.length; ++i) {
            if (i != newArr.length - 1) {
                System.out.print(newArr[i] + ",");
            } else {
                System.out.println(newArr[i]);
            }
        }
    }

}