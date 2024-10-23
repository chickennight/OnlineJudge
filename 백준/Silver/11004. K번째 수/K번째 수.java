import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; ++i)
            list.add(Integer.parseInt(st.nextToken()));


        Collections.sort(list);

        System.out.println(list.get(K - 1));
    }
}