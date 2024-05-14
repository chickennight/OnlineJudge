import java.util.*;
class Solution {
    
    private class Food{ 
        int index, time;
    
        public Food(int index, int time){
            this.index = index;
            this.time = time;
        }
    }
    
    public int solution(int[] food_times, long k) {
        long sumTime = 0;
        int len = food_times.length;
        for (int i=0; i<len; ++i)
            sumTime += food_times[i];
        
        if(sumTime <= k)
            return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        for (int i=0; i<len; ++i) 
            pq.offer(new Food(i+1, food_times[i]));
        
        sumTime = 0;
        long prev = 0;
        
        int now;
        while(sumTime + ((pq.peek().time - prev) * len) <= k){
            now = pq.poll().time;
            sumTime += (now - prev) * len;
            prev = now;
            --len;
        }
        
        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        
        result.sort((o1, o2) -> Integer.compare(o1.index, o2.index));
        
        return result.get((int) ((k-sumTime) % len)).index;
    }
}