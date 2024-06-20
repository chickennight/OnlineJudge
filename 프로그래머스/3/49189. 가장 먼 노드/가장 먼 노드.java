// 가장 먼 노드
import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=1; i<=n; ++i)
            list[i] = new ArrayList<>();
        
        for(int[] vertex: edge){
            list[vertex[0]].add(vertex[1]);
            list[vertex[1]].add(vertex[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        int size,now,cnt=0;
        while(true){
            size = q.size();
            cnt = size;
            while(size-->0){
                now = q.poll();
                for(int next: list[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            if(q.isEmpty()) 
                return cnt;
        }
    }
}