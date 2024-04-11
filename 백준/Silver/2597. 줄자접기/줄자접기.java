import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        double first;
        double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }

    private static final Pair[] arr = new Pair[3];


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        double len = Double.parseDouble(in.readLine());
        double[] lr = {0, len};

        StringTokenizer st;
        double first, second;
        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(in.readLine());
            first = Double.parseDouble(st.nextToken());
            second = Double.parseDouble(st.nextToken());
            arr[i] = new Pair(first, second);
        }

        for (int i = 0; i < 3; ++i)
            func(i, lr);

        double res = lr[1] - lr[0];
        res *= 10;
        res = Math.floor(res);
        res /= 10;
        System.out.printf("%.1f", res);
    }

    private static double update(double mid, double num) {
        return mid + Math.abs(mid - num);
    }

    private static void func(int idx, double[] lr) {
        double l = lr[0];
        double r = lr[1];
        if (arr[idx].first == arr[idx].second)
            return;

        double mid = (arr[idx].first + arr[idx].second) / 2;

        for (int i = idx + 1; i < 3; ++i) {
            arr[i].first = update(mid, arr[i].first);
            arr[i].second = update(mid, arr[i].second);
        }

        l = update(mid, l);
        if (l > r)
            r = l;
        l = mid;

        lr[0] = l;
        lr[1] = r;
    }

}