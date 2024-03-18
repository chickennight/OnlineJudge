import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st;
        for(int i=0;i<operations.length;++i) {
            st = new StringTokenizer(operations[i]," ");
            char order = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            
            if(order == 'I'){
                minQ.add(n);
                maxQ.add(n);
            } else {
                if(!maxQ.isEmpty())
                    if(n == 1) minQ.remove(maxQ.poll());
                    else maxQ.remove(minQ.poll());  
            }
        }
        
        if(!maxQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }

	    return answer;
    }
}