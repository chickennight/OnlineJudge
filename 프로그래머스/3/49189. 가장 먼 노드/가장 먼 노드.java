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
        int[] cntArr = new int[n+1];
        Arrays.fill(cntArr,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        cntArr[1] = 0;
        int size,now,dist=1,cnt=0;
        while(true){
            size = q.size();
            cnt = size;
            while(size-->0){
                now = q.poll();
                for(int next: list[now]){
                    if(cntArr[next]==-1){
                        cntArr[next] = dist;
                        q.add(next);
                        cnt++;
                    }
                }
            }
            if(q.isEmpty()) return cnt;
            dist++;
        }
    }
}