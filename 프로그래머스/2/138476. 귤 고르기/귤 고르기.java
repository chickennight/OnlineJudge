import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int num: tangerine) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        ArrayList<Integer> value = new ArrayList<>(map.values());
        Collections.sort(value, Collections.reverseOrder());
        
        for(int v: value){
            if (sum+v >= k){
                cnt++;
                break;
            }else{
                sum += v;
                cnt++;
            }
        }
        
        return cnt;
    }
}