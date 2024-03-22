class Solution {
    public int[] solution(int n, int s) {
        
        if(s<n) return new int[]{-1};
        
        int[] answer = new int[n];
        int result = s/n;
        
        for(int i=0; i<n; ++i) 
            answer[i] = result;
        for(int i=n-1; i>n-1-s%n; --i)
            answer[i]++;
        
        return answer;
    }
}