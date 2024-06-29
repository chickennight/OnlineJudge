import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int N, lastNode, visitedCnt;
    static Node[] tree;
    static boolean[] visited;
    static List<Integer> similarInOrderStatus, inOrderStatus;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        tree = new Node[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[num] = new Node(left, right);
        }

        inOrderStatus = new ArrayList<>();
        inOrder(1);

        lastNode = inOrderStatus.get(N - 1);

        similarInOrderStatus = new ArrayList<>();
        visited = new boolean[N + 1];
        visited[0] = true;

        similarInOrder(1);
    }

    private static void similarInOrder(int now) {
        similarInOrderStatus.add(now);

        if (!visited[now]) {
            visited[now] = true;
            visitedCnt++;
        }

        Node node = tree[now];
        int left = node.left;
        int right = node.right;

        if (left != -1) {
            similarInOrder(node.left);
            similarInOrderStatus.add(now);
        }

        if (right != -1) {
            similarInOrder(node.right);
            similarInOrderStatus.add(now);
        }

        if (visitedCnt == N && now == lastNode) {
            System.out.println(similarInOrderStatus.size() - 1);
            System.exit(0);
        }
    }

    private static void inOrder(int now) {
        Node node = tree[now];
        int left = node.left;
        int right = node.right;

        if (left != -1)
            inOrder(left);
        inOrderStatus.add(now);

        if (right != -1)
            inOrder(right);
    }
}