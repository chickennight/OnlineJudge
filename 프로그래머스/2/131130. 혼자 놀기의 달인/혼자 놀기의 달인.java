import java.util.*;
class Solution {
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        
        int len = cards.length;
        boolean[] visited = new boolean[len];
        for(int i=0; i<len; ++i){
            if(visited[i]) continue;
            int cnt = 1;
            visited[i] = true;
            int idx = i;
            while(!visited[cards[idx]-1]){
                cnt++;
                idx = cards[idx]-1;
                visited[idx] = true;
            }
            list.add(cnt);
            
        }
        
        if(list.size()==1) return 0;
        
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }
}