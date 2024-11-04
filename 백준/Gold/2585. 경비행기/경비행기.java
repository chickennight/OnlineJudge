import java.util.*;
import java.io.*;

public class Main {

    private static class Node {
        int y;
        int x;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k;
    static ArrayList<Node> list = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list.add(new Node(0, 0));
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }
        int left = 0;
        int right = 1500;
        int result = 0;
        while (left <= right) {
            check = new boolean[1001];
            int mid = (left + right) / 2;
            double a = mid * mid * 100;
            if (bfs(a)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }

    static boolean bfs(double dis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cnt = 0;
        int size = 0;
        double dis1;
        double disto;
        while (!q.isEmpty()) {
            size = q.size();
            if (cnt > k)
                return true;
            for (int i = 0; i < size; ++i) {
                int num = q.poll();
                if (!check[num]) {
                    check[num] = true;
                    for (int j = 1; j <= n; ++j) {
                        int tx = list.get(j).x - list.get(num).x;
                        int ty = list.get(j).y - list.get(num).y;
                        dis1 = Math.pow(tx, 2) + Math.pow(ty, 2);
                        if (dis1 <= dis) {
                            int rx = 10000 - list.get(j).x;
                            int ry = 10000 - list.get(j).y;
                            disto = Math.pow(rx, 2) + Math.pow(ry, 2);
                            if (disto <= dis) {
                                return false;
                            }
                            q.add(j);
                        }
                    }
                }
            }
            cnt++;
        }
        return true;
    }
}