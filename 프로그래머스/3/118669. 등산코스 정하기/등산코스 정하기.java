import java.util.*;

class Solution {
    
    private class Edge implements Comparable<Edge> {
        int node;
        int dist;
        
        public Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge a) {
            return this.dist - a.dist;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Edge>[] graphs = new ArrayList[n+1];
        int[] visited = new int[n+1];
        boolean[] isSummits = new boolean[n+1];
        
        for (int i=1; i<=n; ++i) 
            graphs[i] = new ArrayList<Edge>();
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        for (int summit: summits) 
            isSummits[summit] = true;
        
        for (int[] path: paths) {
            int a = path[0];
            int b = path[1];
            int c = path[2];
            graphs[a].add(new Edge(b, c));
            graphs[b].add(new Edge(a, c));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for(int gate: gates) {
            visited[gate] = 0;
            pq.add(new Edge(gate, 0));
        }
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if (visited[now.node] < now.dist) continue;
            
            for (Edge next: graphs[now.node]) {
                if (visited[next.node] <= Math.max(now.dist, next.dist)) 
                    continue;
                visited[next.node] = Math.max(now.dist, next.dist);
                if (isSummits[next.node]) 
                    continue;
                pq.add(new Edge(next.node, visited[next.node]));
            }
        }
        
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int summit: summits) {
            if (visited[summit] < min) {
                min = visited[summit];
                node = summit;
            } else if (visited[summit] == min && summit < node) {
                min = visited[summit];
                node = summit;              
            }
        }
        int[] answer = {node, min};
        return answer;
    }
    
}