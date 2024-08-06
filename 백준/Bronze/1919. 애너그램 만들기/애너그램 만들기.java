import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str1 = in.readLine();
        String str2 = in.readLine();
        int cnt = 0;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < str1.length(); ++i)
            cnt1[str1.charAt(i) - 'a']++;
        
        for (int i = 0; i < str2.length(); ++i)
            cnt2[str2.charAt(i) - 'a']++;

        for (int i = 0; i < 26; ++i) {
            int compare = cnt1[i] - cnt2[i];
            if (compare != 0) cnt += Math.abs(compare);
        }

        System.out.println(cnt);
    }

}
