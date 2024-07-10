import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville)
            pq.add(n);
        
        while(pq.peek() < K && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}