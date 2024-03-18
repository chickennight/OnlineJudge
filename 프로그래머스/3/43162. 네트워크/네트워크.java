import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;++i)
            list[i] = new ArrayList<>();
        
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                if(i!=j&&computers[i][j]==1){
                    list[i+1].add(j+1);
                    list[j+1].add(i+1);
                }
        
        boolean[] visit = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;++i){
            if(!visit[i]){
                visit[i] = true;
                q.add(i);
                answer++;
                while(!q.isEmpty()){
                    int now = q.poll();
                    for(int next:list[now]){
                        if(!visit[next]){
                            visit[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
}