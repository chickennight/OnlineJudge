import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = in.readLine();
            if (str.equals("#")) {
                break;
            } else {
                String word = String.valueOf(str.charAt(0));
                int n1 = str.length() - str.replace(word.toLowerCase(), "").length();
                int n2 = str.length() - str.replace(word.toUpperCase(), "").length();
                int result = n1 + n2 - 1;
                sb.append(word).append(" ").append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}