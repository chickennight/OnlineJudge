class Solution {
    
    private int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int idx = 0;
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                map[i][j] = ++idx;
            }
        }
        
        int[] answer = new int[queries.length];
        
        int[] range;
        for(int i=0; i<queries.length; ++i){
            range = queries[i];
            answer[i] = rotate(range[0]-1,range[1]-1,range[2]-1,range[3]-1);
        }
        
        return answer;
    }
    
    private int rotate(int x1, int y1, int x2, int y2){
        int min = map[x1][y1];
        int prev = map[x1][y1];
        
        int temp;
        for(int i=y1+1; i<=y2; ++i){
            temp = map[x1][i];
            map[x1][i] = prev;
            prev = temp;
            min = Math.min(min,prev);
        }
        for(int i=x1+1; i<=x2; ++i){
            temp = map[i][y2];
            map[i][y2] = prev;
            prev = temp;
            min = Math.min(min,prev);
        }
        for(int i=y2-1; i>=y1; --i){
            temp = map[x2][i];
            map[x2][i] = prev;
            prev = temp;
            min = Math.min(min,prev);
        }
        for(int i=x2-1; i>=x1; --i){
            temp = map[i][y1];
            map[i][y1] = prev;
            prev = temp;
            min = Math.min(min,prev);
        }
        return min;
    }
}