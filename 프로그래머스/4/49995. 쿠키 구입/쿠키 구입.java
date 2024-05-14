class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for (int i=0; i<cookie.length-1; ++i) {
            int l = i;
            int lSum = cookie[i];

            int r = i+1;
            int rSum = cookie[i+1];

            while (true) {
                if (lSum==rSum && answer<lSum){
                    answer = lSum; 
                }else if (lSum<=rSum && l!=0){
                    lSum +=  cookie[--l];
                }else if (lSum>rSum && r!=cookie.length-1){
                    rSum +=  cookie[++r];
                }else{
                    break;
                }
            }
        }

        return answer;
    }
}