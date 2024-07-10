import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        boolean[] visited = new boolean[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        int cnt = 1, size, now, next;
        while(!q.isEmpty()){
            size = q.size();
            while(size-- > 0){
                now = q.poll();
                next = now + n;
                if(next > y) continue;
                if(!visited[next]){
                    if(next == y) return cnt;
                    visited[next] = true;
                    q.add(next);
                }
                next = now * 2;
                if(next > y) continue;
                if(!visited[next]){
                    if(next == y) return cnt;
                    visited[next] = true;
                    q.add(next);
                }
                next = now * 3;
                if(next > y) continue;
                if(!visited[next]){
                    if(next == y) return cnt;
                    visited[next] = true;
                    q.add(next);
                }
            }
            cnt++;
        }
        return -1;
    }
    
}