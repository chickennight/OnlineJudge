import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; ++i)
            A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(in.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; ++i)
            B[i] = Integer.parseInt(st.nextToken());
        ArrayList<Long> setA = new ArrayList<>();
        makeSet(setA, A);
        ArrayList<Long> setB = new ArrayList<>();
        makeSet(setB, B);

        long cnt = getCnt(setB, setA, T);

        System.out.println(cnt);

    }

    private static void makeSet(ArrayList<Long> set, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            long val = 0;
            for (int j = i; j < arr.length; ++j) {
                val += arr[j];
                set.add(val);
            }
        }
        Collections.sort(set);
    }

    private static long getCnt(ArrayList<Long> setB, ArrayList<Long> setA, int T) {
        long cnt = 0;
        int l = 0;
        int r = setB.size() - 1;
        while (l < setA.size() && r >= 0) {
            long a = setA.get(l);
            long b = setB.get(r);
            long sum = a + b;

            if (sum < T) l++;
            else if (sum > T) r--;
            else {
                long cntA = 0;
                while (l < setA.size() && a == setA.get(l)) {
                    l++;
                    cntA++;
                }

                long cntB = 0;
                while (r >= 0 && b == setB.get(r)) {
                    r--;
                    cntB++;
                }

                cnt += cntA * cntB;
            }
        }
        return cnt;
    }


}