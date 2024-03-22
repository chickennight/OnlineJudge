import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int size = stones.length;
        int l = 1;
        int r = 200000000;
        int mid;
        int answer = 0;
        
        while (l <= r) {
            mid = ((l+r) >> 1);
            int max = -1;
            int cnt = 0;

            for(int i=0; i<size; ++i){
                if (stones[i] <= mid) 
                    cnt++;
                else {
                    max = Math.max(max,cnt);
                    cnt = 0;
                }
            }
        
            max = Math.max(max,cnt);

            if (max < k) l = mid+1;
            else {
                answer = mid;
                r = mid-1;
            }
        }
        
        return answer;
    }
}