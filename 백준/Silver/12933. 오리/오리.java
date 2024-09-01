import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int N = 5;
        char[] sound = {'q', 'u', 'a', 'c', 'k'};
        String sounds = in.readLine();
        int len = sounds.length();
        boolean[] used = new boolean[len];

        if (len % 5 != 0 || sounds.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }

        int ans = 0;
        for (int i = 0; i < len; ++i) {
            if (used[i]) continue;

            int idx = 0;
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < len; ++j) {
                if (!used[j] && sound[idx] == sounds.charAt(j)) {
                    used[j] = true;
                    list.add(sound[idx]);
                    idx = (idx + 1) % N;
                }
            }

            int duck = list.size();
            if (duck != 0 && duck % N == 0) {
                ans++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }

}
