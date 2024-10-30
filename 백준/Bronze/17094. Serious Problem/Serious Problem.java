import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int inputLength = Integer.parseInt(in.readLine());
        int count2 = 0;
        int countE = 0;
        String word = in.readLine();

        char[] arr = new char[inputLength];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = word.charAt(i);
            if (arr[i] == '2') {
                count2 += 1;
            } else {
                countE += 1;
            }
        }

        if (count2 == countE) {
            System.out.print("yee");
        } else if (count2 > countE) {
            System.out.print("2");
        } else {
            System.out.print("e");
        }
    }
}