import java.util.*;

class Solution {
    
    private int h, w;
    private boolean[][] visited;
    private char[][] map;
    
    public int[] solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        visited = new boolean[h][w];
        map = new char[h][w];
        for(int i = 0 ; i < h ; ++i)
            map[i] = maps[i].toCharArray();
                
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < h ; ++i){
            for(int j = 0 ; j < w ; ++j){
                if(map[i][j] != 'X' && !visited[i][j]){
                    list.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(list);
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int x, int y){
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int[] now;
        int nx, ny, cnt = (map[x][y] - '0');
        while(!q.isEmpty()){
            now = q.poll();
            for(int d = 0 ; d < 4 ; ++d){
                nx = now[0] + dx[d];
                ny = now[1] + dy[d];
                
                if(outOfRange(nx, ny) || map[nx][ny] == 'X' || visited[nx][ny]) continue;
                
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt += (map[nx][ny] - '0');
            }
        }
        
        return cnt;
    }
    
    private boolean outOfRange(int x, int y){
        return x >= h || x < 0 || y >= w || y < 0;
    }
}