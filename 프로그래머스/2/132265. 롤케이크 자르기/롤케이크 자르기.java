import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int n : topping)
            right.put(n, right.getOrDefault(n, 0) + 1);
        
        for(int i = 0 ; i < topping.length - 1 ; ++i){
            int n = topping[i];
            left.put(n, left.getOrDefault(n, 0) + 1);
            if(right.get(n) == 1)
                right.remove(n);
            else
                right.put(n, right.getOrDefault(n, 0) - 1);
            
            if(left.size() == right.size())
                answer++;
            
        }
        return answer;
    }
}