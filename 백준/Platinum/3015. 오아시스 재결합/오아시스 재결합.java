import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        int height, cnt;
        public Person(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Stack<Person> stack = new Stack<>();

        long ans = 0;
        for (int i = 0; i < N; ++i) {
            int now = Integer.parseInt(in.readLine());
            Person next = new Person(now, 1);
            while (!stack.isEmpty() && stack.peek().height <= now) {
                Person p = stack.pop();
                ans += p.cnt;
                if (p.height == now) next.cnt += p.cnt;
            }

            if (!stack.isEmpty()) ans++;
            stack.push(next);
        }
        System.out.print(ans);
    }
}