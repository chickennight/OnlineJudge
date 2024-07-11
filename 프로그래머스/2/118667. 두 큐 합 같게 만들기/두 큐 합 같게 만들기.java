import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = sum(queue1);
        long sum2 = sum(queue2);
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();  
        
        for(int i = 0 ; i < queue1.length ; ++i){
            q1.add(queue1[i]);            
            q2.add(queue2[i]);
        }
        
        while(sum1 != sum2){
            if(answer > (queue1.length + queue2.length) * 2)
                return -1;
            
            int num = 0;
            if(sum1 < sum2){
                num = q2.poll();
                q1.add(num);
                sum1 += (long)num;
                sum2 -= (long)num;
            }else if(sum1 > sum2){
                num = q1.poll();
                q2.add(num);
                sum1 -= (long)num;
                sum2 += (long)num;
            }else{
                return answer;
            }
                         
            answer++;
        }
                         
        return answer;
    }
    
    private long sum(int[] arr){
        long sum = 0;
        for(int i = 0 ; i < arr.length ; ++i)
            sum += (long)arr[i];
        return sum;
    }
}