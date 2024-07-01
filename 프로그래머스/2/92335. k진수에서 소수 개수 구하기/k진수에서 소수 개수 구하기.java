import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String s = Integer.toString(n,k);
        
        int answer = 0;
        StringTokenizer st = new StringTokenizer(s,"0");
        
        while(st.hasMoreTokens()){
            if(isPrime(Long.parseLong(st.nextToken()))) answer++;
        }
        return answer;
    }
    
    private boolean isPrime(long n) {
		if(n < 2) 
			return false;
		
		if(n == 2) 
			return true;
		
		for(int i=2; i<=Math.sqrt(n); ++i) 
			if(n%i == 0) 
				return false;
			
		return true;
	}
}