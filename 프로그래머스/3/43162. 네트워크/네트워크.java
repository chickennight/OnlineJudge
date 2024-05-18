import java.util.*;

class Solution {
    
    private void bfs(int num, boolean[] visited, int[][] computers){
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
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; ++i){
            if(!visited[i]){
                bfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
        
        
        
        
        
        
        
        
        
        
//         int answer = 0;
//         List<Integer>[] list = new ArrayList[n+1];
//         for(int i=1; i<=n; ++i)
//             list[i] = new ArrayList<>();
        
//         for(int i=0; i<n; ++i)
//             for(int j=0; j<n; ++j)
//                 if(i!=j && computers[i][j]==1){
//                     list[i+1].add(j+1);
//                     list[j+1].add(i+1);
//                 }
        
//         boolean[] visited = new boolean[n+1];
//         Queue<Integer> q = new LinkedList<>();
//         int now;
//         for(int i=1; i<=n; ++i){
//             if(!visited[i]){
//                 visited[i] = true;
//                 q.add(i);
//                 answer++;
//                 while(!q.isEmpty()){
//                     now = q.poll();
//                     for(int next: list[now]){
//                         if(!visited[next]){
//                             visited[next] = true;
//                             q.add(next);
//                         }
//                     }
//                 }
//             }
//         }
        
//         return answer;
    }
    
}