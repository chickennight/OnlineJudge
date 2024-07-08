import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] h = new int[N + 1];
        int[] cnt = new int[N + 1], near = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            h[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; ++i) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if (cnt[i] > 0) near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = N; i > 0; --i) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            int s = stack.size();
            cnt[i] += s;
            if (s > 0 && stack.peek() - i < i - near[i]) near[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            sb.append(cnt[i]);
            if (cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}