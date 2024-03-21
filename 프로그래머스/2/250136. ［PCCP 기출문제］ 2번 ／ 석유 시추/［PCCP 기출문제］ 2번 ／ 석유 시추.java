import java.util.*;
class Solution {
    private int n,m;
    private Queue<int[]> q;
    private Map<Integer,Integer> map;
    private final int[] dx = {1,-1,0,0};
    private final int[] dy = {0,0,1,-1};
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        q = new LinkedList<>();
        map = new HashMap<>();
        
        calculate(land);
        
        for(int i=0; i<m; ++i)
            answer=Math.max(cntLand(i,land),answer);
        
        return answer;
    }
    
    private void calculate(int[][] land){
        boolean[][] visited = new boolean[n][m];
        int i,j,d,nx,ny,cnt,num = 2;
        for(i=0; i<n; ++i){
            for(j=0; j<m; ++j){
                if(!visited[i][j] && land[i][j]==1){
                    cnt = 0;
                    q.add(new int[]{i,j});
                    land[i][j] = num;
                    cnt++;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(d=0; d<dx.length; ++d){
                            nx = now[0] + dx[d];
                            ny = now[1] + dy[d];
                            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                            if(land[nx][ny]!=1) continue;
                            q.add(new int[]{nx,ny});
                            land[nx][ny] = num;
                            cnt++;
                        }
                    }
                    map.put(num,cnt);
                    num++;
                }
            }
        }
    }
    
    private int cntLand(int idx, int[][] land){
        Set<Integer> set = new HashSet<>();
        int i,num,result=0;
        for(i=0; i<n; ++i){
            num = land[i][idx];
            if(num==0) continue;
            if(!set.contains(num)){
                result += map.get(num);
                set.add(num);
            }
        }
        return result;
        
    }
}