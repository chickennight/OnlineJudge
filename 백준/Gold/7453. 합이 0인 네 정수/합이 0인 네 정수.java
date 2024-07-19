import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[][] arr = new int[n][4];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[n * n];
        int[] cd = new int[n * n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ab[i * n + j] = arr[i][0] + arr[j][1];
                cd[i * n + j] = (arr[i][2] + arr[j][3]);
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        System.out.println(getCnt(n, ab, cd));

    }

    private static long getCnt(int n, int[] ab, int[] cd) {
        int abIdx = 0;
        int cdIdx = n * n - 1;
        long cnt = 0;
        while (abIdx < n * n && cdIdx > -1) {
            long abVal = ab[abIdx], cdVal = cd[cdIdx];
            long temp = abVal + cdVal;
            if (temp < 0) {
                abIdx += 1;
            } else if (temp > 0) {
                cdIdx -= 1;
            } else {
                long xCnt = 0, yCnt = 0;
                while (abIdx < n * n && abVal == ab[abIdx]) {
                    abIdx++;
                    xCnt++;
                }
                while (cdIdx > -1 && cdVal == cd[cdIdx]) {
                    cdIdx--;
                    yCnt++;
                }
                cnt += xCnt * yCnt;
            }
        }
        return cnt;
    }
}