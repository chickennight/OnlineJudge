import java.util.*;
class Solution {
    public long solution(int[] A, int[][] edges) {
        int size = A.length;
        long answer = 0;
        long total = 0;
        long[] a = new long[size];
        for(int i=0; i<size; ++i) {
            total += A[i];
            a[i] = (long)A[i];
        }
        if(total != 0) return -1;
        
        int[] linked = new int[size];
        List<Integer>[] tree = new ArrayList[size];
        for(int i=0; i<size; ++i) 
            tree[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            tree[x].add(y);
            tree[y].add(x);
            linked[x]++;
            linked[y]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<size; ++i){
            if(linked[i]==1) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: tree[now]){
                if(linked[next] > 0){
                    linked[now]--;
                    linked[next]--;
                    
                    answer += Math.abs(a[now]);
                    a[next] += a[now];
                    
                    if(linked[next]==1) 
                        q.add(next);

                    
                    break;
                }
            }
        }
        
        return answer;
    }
}