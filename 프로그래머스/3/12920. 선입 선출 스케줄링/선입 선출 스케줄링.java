import java.util.*;

class Solution {

    public int solution(int n, int[] cores) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < cores.length; ++i)
            max = Math.max(max, cores[i]);

        int r = n * max / cores.length + 1;
        int l = 0;

        while(l < r) {
            int mid = (l + r) / 2;
            int core = check(mid,n,cores);

            if (core == Integer.MAX_VALUE) l = mid;
            else if (core == -1) r = mid;
            else {
                answer = core;
                break;
            }
        }
        
        return answer;
    }
    
    private int check(int t, int n, int[] cores) {
        List<Integer> list = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < cores.length; ++i) {
            cnt += (t / cores[i] + 1);
            if (t % cores[i] == 0)
                list.add(i + 1);
        }

        if (cnt < n) return Integer.MAX_VALUE;
        else if (n <= cnt - list.size()) return -1;
        else {
            return list.get(n - (cnt - list.size()) - 1);
        }
    }
    
}