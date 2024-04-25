import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        ArrayList<Integer> primeList = getPrimeList((int) Math.sqrt(b));
        int cnt = 0, tempCnt, nowCnt;
        long temp;
        for (long now : primeList) {
            nowCnt = getLength(now);
            temp = now;
            while ((temp *= now) <= b) {
                if (a <= temp)
                    cnt++;
                tempCnt = getLength(temp);
                if (nowCnt + tempCnt > 15)
                    break;
            }
        }
        System.out.println(cnt);
    }

    private static ArrayList<Integer> getPrimeList(int LIMIT) {
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean[] isPrimeList = new boolean[LIMIT + 1];
        int sqrtN = (int) Math.sqrt(LIMIT);
        for (int i = 3; i <= sqrtN; i += 2) {
            if (isPrimeList[i]) continue;
            int base = i + i;
            while (base <= LIMIT) {
                isPrimeList[base] = true;
                base += i;
            }
        }
        primeList.add(2);
        for (int i = 3; i <= LIMIT; i += 2) {
            if (!isPrimeList[i]) primeList.add(i);
        }
        return primeList;
    }

    private static int getLength(long num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}