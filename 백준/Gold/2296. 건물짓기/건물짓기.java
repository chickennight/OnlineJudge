import java.util.*;
import java.io.*;

public class Main {
    private static class building {
        int x, y, cost;

        building(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        List<building> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new building(x, y, cost));
        }

        list.sort(Comparator.comparingInt(a -> a.x));

        int[][] dp = new int[1000][2];
        int result = 0;

        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = list.get(i).cost;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (list.get(j).y < list.get(i).y)
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + list.get(i).cost);
                if (list.get(j).y > list.get(i).y)
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + list.get(i).cost);
            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);
    }
}