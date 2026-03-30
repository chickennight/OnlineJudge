import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n=times.length;
        int answer = -1;
        int L=1;
        int R=100000;
        int cnt = 1;
        while(L<=R){
            int mid = (L+R)/2;
            long temp = 0;
            int prev = 0;
            for(int i=0; i<diffs.length; ++i){
                temp+=timeCost(mid,diffs[i],prev,times[i]);
                prev = times[i];
            }
            if(temp<=limit){
                answer=mid;
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        
        return answer;
    }
        
    private static long timeCost(int level, int diff, int prev, int cur){
        if(level >= diff)
            return (long)cur;
        else
            return (long)((diff-level)*(prev+cur) + cur); 
        
    }
}