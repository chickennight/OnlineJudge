import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i,j,k;
        for(int a=0; a<commands.length; ++a){
            i=commands[a][0];
            j=commands[a][1];
            k=commands[a][2];
            int[] temp = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(temp);
            answer[a] = temp[k-1];
        }
        return answer;
    }
}