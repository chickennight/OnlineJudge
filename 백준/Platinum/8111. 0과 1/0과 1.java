import java.io.*;
import java.util.*;

public class Main {

    private static class Data {
        int num;
        StringBuilder sb;

        public Data(int num, String s, String add) {
            this.num = num;
            sb = new StringBuilder(s);
            sb.insert(0, add);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Data> q = new LinkedList<>();
        boolean[] visited;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            q.clear();
            int num = Integer.parseInt(in.readLine());
            visited = new boolean[num + 1];
            visited[num] = true;
            boolean isFind = false;

            for (int i = 1; i < 10; ++i) {
                int calc = num * i;
                if (calc % 10 == 1) {
                    q.add(new Data(calc / 10, "", "1"));
                    visited[calc / 10] = true;
                } else if (calc % 10 == 0) {
                    q.add(new Data(calc / 10, "", "0"));
                    visited[calc / 10] = true;
                }
            }

            while (!q.isEmpty()) {
                Data data = q.poll();

                if (data.sb.length() > 100) continue;
                if (data.num == num) continue;

                if (data.num == 0) {
                    sb.append(data.sb).append("\n");
                    isFind = true;
                    break;
                }
                for (int i = 0; i < 10; ++i) {
                    int calc = data.num + (num * i);
                    int div = calc / 10;
                    if (!visited[div]) {
                        if (calc % 10 == 1) {
                            q.add(new Data(calc / 10, data.sb.toString(), "1"));
                            visited[div] = true;
                        } else if (calc % 10 == 0) {
                            q.add(new Data(calc / 10, data.sb.toString(), "0"));
                            visited[div] = true;
                        }
                    }
                }
            }

            if (!isFind) {
                sb.append("BRAK").append("\n");
            }
        }

        System.out.println(sb);
    }

}