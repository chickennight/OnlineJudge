import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; ++i)
            bridge.add(0);
        
        
        if(bridge_length == 1) 
            return truck_weights.length+1;
        
        if(truck_weights.length == 1) 
            return bridge_length+1;
        
        int idx = 0;
        int nowWeight = 0;
        while(idx < truck_weights.length){
            nowWeight -= bridge.poll();
            answer++;
            
            if(nowWeight + truck_weights[idx] <= weight){
                bridge.add(truck_weights[idx]);
                nowWeight += truck_weights[idx++];
            }
            else bridge.add(0);
        }
        
        return answer + bridge_length;
    }
}