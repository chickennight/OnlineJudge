class Solution {
    private int[] answer;
    private int[][] arr;
    
    public int[] solution(int[][] array) {
        int size = array.length;
        arr = array;
        answer = new int[2];
        segment(0,0,size);
        return answer;
    }
    
    private void segment(int x1, int y1, int len){
        if(len == 1){
            answer[arr[x1][y1]]++;
            return;
        }
        
        int start = arr[x1][y1];
        boolean tf = true;
        loop:
        for(int i=x1; i<=x1+len-1; ++i){
            for(int j=y1; j<=y1+len-1; ++j){
                if(arr[i][j]!=start){
                    tf = false;
                    break loop;
                }
            }
        }
                
        if(tf) {
            answer[start]++;
            return;
        }
        
        for(int i=x1; i<=x1+len-1; i+=len/2){
            for(int j=y1; j<=y1+len-1; j+=len/2){
                segment(i,j,len/2);
            }
        }
    }
}