class Solution {
    
    private char[][] blockMap;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        blockMap = new char[m][n];
 
        for(int i = 0 ; i < board.length ; ++i){
            for(int j = 0 ; j < board[i].length() ; ++j){
                blockMap[i][j] = board[i].charAt(j);
            }
        }
 
        while (true) {
            boolean[][] isSame = new boolean[m][n];
            checkBlock(m, n, isSame);
            int count = countBlock(m, n, isSame);
            
            if (count == 0) 
                break;
            
            answer += count;
 
            dropBlock(m, n);
        }
 
        return answer;
    }
 
    private void dropBlock(int m, int n){
        for(int i = m - 1 ; i >= 0 ; --i){
            for(int j = 0 ; j < n ; ++j){
                if(blockMap[i][j] != '-') 
                    continue;
                
                if(blockMap[i][j] == '-'){
                    for(int k = i - 1 ; k >= 0 ; --k){
                        if(blockMap[k][j] != '-'){
                            blockMap[i][j] = blockMap[k][j];
                            blockMap[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }
 
    private void checkBlock(int m, int n, boolean[][] isSame){
        for(int i = 0 ; i < m - 1 ; ++i){
            for(int j = 0 ; j < n - 1 ; ++j){
                char block = blockMap[i][j];
                if(blockMap[i + 1][j] == block && blockMap[i][j + 1] == block && blockMap[i + 1][j + 1] == block){
                    isSame[i + 1][j] = true;
                    isSame[i][j + 1] = true;
                    isSame[i + 1][j + 1] = true;
                    isSame[i][j] = true;
                }
            }
        }
    }
 
    private int countBlock(int m, int n, boolean[][] isSame){
        int count = 0;
 
        for(int i = 0 ; i < m ; ++i){
            for(int j = 0 ; j < n ; ++j){
                if(!isSame[i][j])
                    continue;
                
                if(isSame[i][j] && blockMap[i][j] != '-'){
                    count++;
                    blockMap[i][j] = '-';
                }
            }
        }
        return count;
    }
}