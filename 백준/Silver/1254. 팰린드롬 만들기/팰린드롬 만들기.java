import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        int ans = s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome(s.substring(i))) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            if (s.charAt(start) != s.charAt(last))
                return false;
            start++;
            last--;
        }
        return true;
    }
}
