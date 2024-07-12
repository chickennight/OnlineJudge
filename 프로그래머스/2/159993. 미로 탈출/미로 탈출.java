import java.util.*;

class Solution {
    private char[][] map;
    private int h, w;
    public int solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        map = new char[h][w];
        
        int[] S = new int[2];
        int[] E = new int[2];
        int[] L = new int[2];
        for(int i = 0 ; i < h ; ++i){
            for(int j = 0 ; j < w ; ++j){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    S[0] = i;
                    S[1] = j;
                }else if(map[i][j] == 'E'){
                    E[0] = i;
                    E[1] = j;
                }else if(map[i][j] == 'L'){
                    L[0] = i;
                    L[1] = j;
                }
            }
        }
                    
        int toL = calculateLength(S, L);
        int toE = calculateLength(L, E);
        
        return toL == -1 || toE == -1 ? -1 : toL + toE;
    }
    
    private int calculateLength(int[] start, int[] end){
        final int[] dx = {-1, 1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] now = q.poll();
                for(int d = 0 ; d < 4 ; ++d){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if(outOfRange(nx, ny) || map[nx][ny] == 'X' || visited[nx][ny]) continue;

                    if(nx == end[0] && ny == end[1]) return cnt;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            cnt++;
        }
        
        return -1;
    }
    
    private boolean outOfRange(int x, int y){
        return x >= h || x < 0 || y >= w || y < 0;
    }
}