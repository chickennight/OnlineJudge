class Solution {
    public long solution(int[] weights) {
        int[] cnts = new int[1001];
        for(int i=0; i<weights.length; ++i){
            cnts[weights[i]]++;
        }
        
        long answer = 0;
        for(int i=100;i<=1000;++i){
            if(cnts[i] > 0){
                answer+=(long)cnts[i]*(cnts[i]-1)/2;
                
                if(i%2==0 && i*3/2<=1000 && cnts[i*3/2]!=0)
                    answer+=(long)cnts[i]*cnts[i*3/2];
                
                if(i%3==0 && i*4/3<=1000 && cnts[i*4/3]!=0)
                    answer+=(long)cnts[i]*cnts[i*4/3];
                
                if(i*2<=1000 && cnts[i*2]!=0)
                    answer+=(long)cnts[i]*cnts[i*2];
            }
        }
        return answer;
    }
}