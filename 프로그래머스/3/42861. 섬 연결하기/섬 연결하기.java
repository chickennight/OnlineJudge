import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs,(o1,o2)->{
            return o1[2]-o2[2];
        });
        
        parent = new int[n+1];
        for(int i=1; i<=n; ++i) parent[i] = i;
        
        int answer = 0;
        for(int i=0; i<costs.length; ++i)
            if(union(costs[i][0],costs[i][1])) 
                answer += costs[i][2];
        
        return answer;
    }
    
    private boolean union(int x, int y) {
	    x = find(x);
	    y = find(y);
    
	    if(x == y) 
            return false;
	
	    if(x <= y) 
            parent[y] = x;
	    else 
            parent[x] = y;
        
	    return true;
    }
        
    private int find(int x) {
	    if(parent[x] == x) return x;
	    return find(parent[x]);
    }
}