import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        final int INF = 999_999_999;

        HashMap<String, Integer> trans = new HashMap<>();
        trans.put("Mugunghwa", 0);
        trans.put("ITX-Saemaeul", 0);
        trans.put("ITX-Cheongchun", 0);
        trans.put("S-Train", 1);
        trans.put("V-Train", 1);
        trans.put("Subway", 2);
        trans.put("Bus", 2);
        trans.put("KTX", 2);
        trans.put("Taxi", 2);
        trans.put("Airplane", 2);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] discountMap = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(map[i], INF);
            Arrays.fill(discountMap[i], INF);
            map[i][i] = 0;
            discountMap[i][i] = 0;
        }

        HashMap<String, Integer> city = new HashMap<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i) {
            city.put(st.nextToken(), i);
        }

        int M = Integer.parseInt(in.readLine());
        String[] travel = new String[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; ++i) {
            travel[i] = st.nextToken();
        }

        int K = Integer.parseInt(in.readLine());
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(in.readLine());
            int dis = trans.get(st.nextToken());
            int s1 = city.get(st.nextToken());
            int s2 = city.get(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            map[s1][s2] = Math.min(map[s1][s2], price * 2);
            map[s2][s1] = map[s1][s2];
            discountMap[s1][s2] = Math.min(discountMap[s1][s2], price * dis);
            discountMap[s2][s1] = discountMap[s1][s2];
        }


        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                if (i == k) {
                    continue;
                }
                for (int j = i + 1; j < N; ++j) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    map[j][i] = map[i][j];
                    discountMap[i][j] = Math.min(discountMap[i][j], discountMap[i][k] + discountMap[k][j]);
                    discountMap[j][i] = discountMap[i][j];
                }
            }
        }

        int result = 0, dresult = R * 2;
        for (int i = 1; i < M; ++i) {
            result += map[city.get(travel[i - 1])][city.get(travel[i])];
            dresult += discountMap[city.get(travel[i - 1])][city.get(travel[i])];
        }
        System.out.println((result <= dresult) ? "No" : "Yes");
    }
}