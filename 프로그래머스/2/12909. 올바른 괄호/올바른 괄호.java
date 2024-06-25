class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '(') cnt++;
            else{
                if(cnt > 0) cnt--;
                else return false;
            }
        }

        return cnt == 0;
    }
}