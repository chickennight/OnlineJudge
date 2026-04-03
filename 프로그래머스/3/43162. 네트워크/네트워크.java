import java.util.*;

class Solution {
    private boolean[] visited;
    private int[][] computers;
    public int solution(int n, int[][] computerArr) {
        visited = new boolean[n];
        computers = computerArr;
        int answer = 0;
        for(int i=0; i<n; ++i){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num]= true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<computers.length; ++i){
                if(computers[i][now]==0 || visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }
        }
    }
    
}