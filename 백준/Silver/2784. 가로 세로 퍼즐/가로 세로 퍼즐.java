import java.util.*;
import java.io.*;

public class Main {

    private static boolean[] visited;
    private static List<String> word;

    private static final List<List<String>> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        word = new ArrayList<>(6);
        visited = new boolean[6];
        for (int i = 0; i < 6; ++i) {
            word.add(in.readLine());
        }

        permutation(new int[3], 0, 3);

        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) sb.append(0);
        else {
            for (int i = 0; i < 3; ++i) {
                sb.append(list.get(0).get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void permutation(int[] ans, int cnt, int R) {
        if (cnt == R) {
            List<String> temp = new ArrayList<>(3);
            List<String> copy = new ArrayList<>(6);
            copy.addAll(word);

            for (int i = 0; i < 3; ++i) {
                temp.add(word.get(ans[i]));
                copy.remove(word.get(ans[i]));
            }

            for (int i = 0; i < 3; ++i) {
                String tempStr = "" +
                        temp.get(0).charAt(i) +
                        temp.get(1).charAt(i) +
                        temp.get(2).charAt(i);

                if (copy.contains(tempStr)) copy.remove(tempStr);
                else return;
            }
            list.add(temp);

            return;
        }

        for (int i = 0; i < 6; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                ans[cnt] = i;
                permutation(ans, cnt + 1, R);
                visited[i] = false;
            }
        }
    }

}