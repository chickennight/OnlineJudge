import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        int size = times.length;
        long l = 0;
        long r = (long)times[size-1]*n;
        
        long mid, total;
        while(l <= r){
            
            mid = ((l+r)>>1);
            total = 0;
            
            for (int i=0; i<size; ++i)
                total += mid/times[i];
            
            if (total < n)
                l = mid+1;
            else {
                r = mid-1;
                answer = mid;
            }
        }  
        
        return answer;
    }
}