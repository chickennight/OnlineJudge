import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; ++i)
            q.add((int) Math.ceil( (100.0-progresses[i]) / speeds[i] ));        
        
        while(!q.isEmpty()){
            
		    int min = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && q.peek() <= min){
                q.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}