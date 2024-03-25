import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; ++i)
            list[i] = new ArrayList<>();
        for(int[] road : roads){
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        
        int[] cnt = new int[n+1];
        Arrays.fill(cnt,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        cnt[destination] = 0;
        int now;
        while(!q.isEmpty()){
            now = q.poll();
            for(int next: list[now]){
                if(cnt[next]==-1){
                    q.add(next);
                    cnt[next] = cnt[now]+1;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; ++i){
            answer[i] = cnt[sources[i]]; 
        }
        return answer;
    }
}