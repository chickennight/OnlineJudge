import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
            return o1[col - 1] - o2[col - 1];
        });
        
        int answer = 0;
        for(int i = row_begin - 1 ; i <= row_end - 1 ; ++i){
            int temp = 0;
            for(int j = 0 ; j < data[0].length; ++j){
                temp += data[i][j] % (i+1);
            }
            if(i == row_begin - 1) answer = temp;
            else answer = answer ^ temp;
        }
        
        return answer;
    }
}