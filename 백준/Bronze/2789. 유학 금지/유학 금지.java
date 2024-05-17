import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] word = "CAMBRIDGE".toCharArray();
        String input = in.readLine();

        for (char c : word) {
            if (input.indexOf(c) > -1) {
                input = input.replace(String.valueOf(c), "");
            }
        }
        System.out.println(input);
    }
}