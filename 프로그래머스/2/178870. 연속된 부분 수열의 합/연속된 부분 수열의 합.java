class Solution {
    public int[] solution(int[] sequence, int k) {
        int size = sequence.length;
        int start = 0, end = size;
        int sum = 0;
        for(int L = 0, R = 0; L < size; ++L) {
            while(R < size && sum < k) 
                sum += sequence[R++];
            
            if(sum == k) {
                int range = R - L - 1;
                if((end - start) > range) {
                    start = L;
                    end = R - 1;
                }
            }
            
            sum -= sequence[L];
        }
        
        int[] answer = {start, end};
        
        return answer;
    }
}