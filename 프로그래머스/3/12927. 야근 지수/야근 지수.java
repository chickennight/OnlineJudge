// 야근 지수
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        
        int size = works.length;
        
        Arrays.sort(works);
        
        for (int i=0; i<n; ++i) {
            int index = binarySearch(works, works[size-1]);

            if (works[index] == 0)
                continue;
            
            works[index]--;
        }
        
        return calculate(works);
    }

    private int binarySearch(int[] works, int target) {
        int l = 0, r = works.length-1, m;
        while (l < r) {
            m = (l+r)/2;
            if (target <= works[m]) 
                r = m;
            else
                l = m+1;
        }
        return l;
    }

    private long calculate(int[] works) {
        long result = 0;
        for (int i=0; i<works.length; ++i) 
            result += works[i]*works[i];
        return result;
    }
}