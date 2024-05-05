import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n) {
            return this.y - n.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int confetti = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(in.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int left = 1;
        int right = Math.min(r, c);
        while (left <= right) {
            int mid = (left + right) / 2;

            if (blindable(mid, confetti, list)) {
                right = mid - 1;
            } else left = mid + 1;
        }
        System.out.println(left);
    }

    private static boolean blindable(int m, int confetti, ArrayList<Node> list) {
        int count = 0;
        int pre = 0;
        for (Node current : list) {
            if (current.x > m)
                return false;

            if (pre == 0 || pre + m <= current.y) {
                pre = current.y;
                ++count;
                if (count > confetti) return false;
            }

        }
        return true;
    }

}