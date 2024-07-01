//프로세스
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        
        int[] arr = new int[10];
        
        for (int n : priorities) 
            arr[n]++;     
        
        int answer = 0;
        int idx = 9;
        while(arr[idx]==0) idx--;
        
        while(idx>=1){
            for (int i=0; i<priorities.length; ++i) {
                if (priorities[i] == idx) {
                    answer++;
                    arr[idx]--;
                    
                    while(idx>=0 && arr[idx]==0) idx--;

                    if (location == i) 
                        return answer;
                }
            }
        }

        return answer;
    }
}