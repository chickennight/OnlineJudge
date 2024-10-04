import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = in.readLine();
            ArrayList<Character> list = new ArrayList<>();

            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '#') {
                    return;
                }
                list.add(s.charAt(i));
            }

            int result = 0;
            for (int i = 0; i < list.size(); i++) {

                switch (list.get(i)) {
                    case '-':
                        result += 0;
                        break;
                    case '(':
                        result += (int) (2 * Math.pow(8, i));
                        break;
                    case '@':
                        result += (int) (3 * Math.pow(8, i));
                        break;
                    case '?':
                        result += (int) (4 * Math.pow(8, i));
                        break;
                    case '>':
                        result += (int) (5 * Math.pow(8, i));
                        break;
                    case '&':
                        result += (int) (6 * Math.pow(8, i));
                        break;
                    case '%':
                        result += (int) (7 * Math.pow(8, i));
                        break;
                    case '/':
                        result += (int) (-1 * Math.pow(8, i));
                        break;
                    default:
                        result += (int) Math.pow(8, i);
                        break;
                }
            }
            System.out.println(result);
        }

    }

}
