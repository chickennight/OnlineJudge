class Solution{
    public int solution(String s){
        char[] arr = s.toCharArray();
        
        for (int leng=s.length(); leng>1; --leng) {
            
            for (int start=0; start+leng<=s.length(); ++start) {
                boolean tf = true;
                
                for (int i=0; i<leng/2; ++i) {
                    if(arr[start+i] != arr[start+leng-i-1]){
                        tf = false;
                        break;
                    }
                }
                
                if (tf) return leng;
            }
        }
        
        return 1;
    }
}