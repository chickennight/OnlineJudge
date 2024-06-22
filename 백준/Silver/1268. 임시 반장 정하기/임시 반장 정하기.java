import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] table = new int[n][5];
        boolean[][] list = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            String[] s = in.readLine().split(" ");
            for (int j = 0; j < s.length; ++j) {
                table[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < 5; ++i) {
            ArrayList<Integer>[] temp = new ArrayList[10];
            for (int j = 0; j < n; ++j) {
                if (temp[table[j][i]] == null)
                    temp[table[j][i]] = new ArrayList<>();

                temp[table[j][i]].add(j);
            }

            for (int j = 0; j < n; ++j) {
                int num = table[j][i];

                ArrayList<Integer> data = temp[num];

                for (Integer datum : data) {
                    if (j == datum)
                        continue;

                    list[j][datum] = true;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < n; ++i) {
            int num = 0;
            
            for (int j = 0; j < n; ++j)
                if (list[i][j])
                    num++;

            if (max < num) {
                max = num;
                index = i;
            }
        }

        System.out.println(index + 1);
    }
}