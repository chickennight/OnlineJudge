import java.util.*;
import java.io.*;

public class Main {

    static String correct = "123456780";
    static Map<String, Integer> map = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; ++j) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(num);
            }
        }

        String start = sb.toString();

        map.put(start, 0);
        System.out.println(bfs(start));
    }

    static int bfs(String start) {

        Queue<String> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            String now = q.poll();
            int move = map.get(now);
            int empty = now.indexOf('0');
            int x = empty % 3;
            int y = empty / 3;

            if (now.equals(correct))
                return move;

            for (int d = 0; d < 4; ++d) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx > 2 || ny > 2) continue;

                int nextNow = ny * 3 + nx;
                char ch = now.charAt(nextNow);
                String next = now.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, move + 1);
                }
            }
        }
        return -1;
    }
}