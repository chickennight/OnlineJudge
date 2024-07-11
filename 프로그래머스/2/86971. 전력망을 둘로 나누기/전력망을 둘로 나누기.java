import java.util.*;
 
class Solution {
 
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int ans = Integer.MAX_VALUE;
 
        for (int i = 1; i <= n; ++i) 
            graph[i] = new ArrayList<>();
        
        int a,b;
        for (int i = 0; i < wires.length; ++i) {
            a = wires[i][0];
            b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
 
        for (int i = 0; i < wires.length; ++i) {
            a = wires[i][0];
            b = wires[i][1];
  
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
 
            int cnt = bfs(n, graph);

            ans = Math.min(ans, Math.abs(2 * cnt - n));
 
            graph[a].add(b);
            graph[b].add(a);
        }
 
        return ans;
    }
 
    static int bfs(int n, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
 
        int now;
        while(!q.isEmpty()){
            now = q.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
 
        return cnt;
    }
}