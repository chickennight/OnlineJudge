import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> ansList;
    static int bottleA, bottleB, bottleC;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        bottleA = Integer.parseInt(st.nextToken());
        bottleB = Integer.parseInt(st.nextToken());
        bottleC = Integer.parseInt(st.nextToken());

        ansList = new ArrayList<>();
        visited = new boolean[201][201][201];

        bfs();
        Collections.sort(ansList);

        for (Integer integer : ansList)
            System.out.print(integer + " ");
    }

    public static void bfs() {
        Queue<Status> q = new LinkedList<>();
        q.add(new Status(0, 0, bottleC));

        while (!q.isEmpty()) {
            Status now = q.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;
            if (visited[a][b][c]) continue;

            visited[a][b][c] = true;
            if (a == 0) ansList.add(c);

            // A -> B
            if (a + b >= bottleB) {
                q.add(new Status(a - (bottleB - b), bottleB, c));
            } else {
                q.add(new Status(0, a + b, c));
            }
            // A -> C
            if (a + c >= bottleC) {
                q.add(new Status(a - (bottleC - c), b, bottleC));
            } else {
                q.add(new Status(0, b, a + c));
            }
            // B -> A
            if (b + a >= bottleA) {
                q.add(new Status(bottleA, b - (bottleA - a), c));
            } else {
                q.add(new Status(b + a, 0, c));
            }
            // B -> C
            if (b + c >= bottleC) {
                q.add(new Status(a, b - (bottleC - c), bottleC));
            } else {
                q.add(new Status(a, 0, b + c));
            }
            // C -> A
            if (c + a >= bottleA) {
                q.add(new Status(bottleA, b, c - (bottleA - a)));
            } else {
                q.add(new Status(a + c, b, 0));
            }
            // C -> B
            if (c + b >= bottleB) {
                q.add(new Status(a, bottleB, c - (bottleB - b)));
            } else {
                q.add(new Status(a, b + c, 0));
            }
        }

    }

    public static class Status {
        int a, b, c;

        public Status(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}