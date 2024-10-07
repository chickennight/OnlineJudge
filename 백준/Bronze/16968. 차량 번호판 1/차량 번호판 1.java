import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        map.put("d", 10);
        map.put("dd", 90);
        map.put("ddd", 810);
        map.put("dddd", 7290);
        map.put("c", 26);
        map.put("cc", 650);
        map.put("ccc", 16250);
        map.put("cccc", 406250);

        String str = in.readLine();
        StringBuilder temp = new StringBuilder(str.charAt(0) + "");
        int answer = 1;
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) == str.charAt(i - 1))
                temp.append(str.charAt(i));
            else {
                answer *= map.get(temp.toString());
                temp = new StringBuilder(str.charAt(i) + "");
            }
        }
        answer *= map.get(temp.toString());
        System.out.println(answer);

    }
}