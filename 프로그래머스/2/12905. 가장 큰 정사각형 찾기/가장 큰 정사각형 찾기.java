class Solution {
    public int solution(int[][] board) {
        int max = 0;
        int h = board.length;
        int w = board[0].length;
        
        if(h < 2 || w < 2)
            return 1;
        
        for(int i = 1 ; i < h ; ++i){
            for(int j = 1 ; j < w ; ++j){
                if(board[i][j] != 0)       
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                max = Math.max(max, board[i][j]);
            }
        }

        return max * max;
    }
}