import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int num;
        int idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    static int n;
    static List<Integer> list;
    static Node[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int[] origin_sw = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i) {
            int sw = Integer.parseInt(st.nextToken());
            origin_sw[i] = sw;
            map.put(sw, i);
        }

        int[] bulb = new int[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            bulb[i] = map.get(Integer.parseInt(st.nextToken()));

        node = new Node[n];
        for (int i = 0; i < n; ++i) {
            if (list.isEmpty() || list.get(list.size() - 1) < bulb[i]) {
                list.add(bulb[i]);
                node[i] = new Node(bulb[i], list.size() - 1);
            } else {
                int idx = binarySearch(bulb[i]);
                list.set(idx, bulb[i]);
                node[i] = new Node(bulb[i], idx);
            }
        }

        int idx = list.size() - 1;
        for (int i = n - 1; i >= 0; --i)
            if (node[i].idx == idx)
                list.set(idx--, origin_sw[node[i].num]);


        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');

        Collections.sort(list);
        for (Integer integer : list)
            sb.append(integer).append(" ");

        System.out.println(sb);
    }

    public static int binarySearch(int num) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (list.get(m) < num)
                l = m + 1;
            else
                r = m - 1;

        }
        return l;
    }

}
