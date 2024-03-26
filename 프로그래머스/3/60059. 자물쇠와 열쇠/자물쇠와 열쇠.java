class Solution {
    static int keySize,lockSize;
    
    public boolean solution(int[][] key, int[][] lock) {
        keySize = key.length;
        lockSize = lock.length;
        
        for(int i=0;i<4;++i){
            key = rotate(key);
            for(int x=-lockSize+1;x<lockSize-1; ++x)
                for(int y=-lockSize+1;y<lockSize-1; ++y)
                    if(isCorrect(key,lock,x,y)) return true;  
        }
        
        return false;
    }
    
    static int[][] rotate(int[][] input){
        int[][] result = new int[keySize][keySize];
        for(int i=0;i<keySize;++i)
            for(int j=0;j<keySize;++j)
                result[i][j] = input[keySize-1-j][i];
        return result;
    }
    
    static boolean isCorrect(int[][] key, int[][] lock, int x, int y){
        for(int i=0;i<lockSize;++i)
            for(int j=0;j<lockSize;++j)
                if(i+x>=keySize||i+x<0||j+y>=keySize||j+y<0){
                    if(lock[i][j]==0) return false;
                }else{
                    if(lock[i][j] == key[i+x][j+y]) return false;   
                }
        return true;
    }
}