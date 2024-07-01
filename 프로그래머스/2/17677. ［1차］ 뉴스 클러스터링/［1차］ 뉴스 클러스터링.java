//뉴스 클러스터링
class Solution {
    public int solution(String str1, String str2) {
        int[][] cnt1 = new int[26][26];
        int[][] cnt2 = new int[26][26];
        
        int i, j, min = 0, max = 0;
        char a,b;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for(i=0; i<str1.length()-1; ++i){
            a = str1.charAt(i);
            b = str1.charAt(i+1);
            if(check(a)||check(b)) continue;
            cnt1[a-'a'][b-'a']++;
        }
        for(i=0; i<str2.length()-1; ++i){
            a = str2.charAt(i);
            b = str2.charAt(i+1);
            if(check(a)||check(b)) continue;
            cnt2[a-'a'][b-'a']++;
        }
        
        for(i=0; i<26; ++i){
            for(j=0; j<26; ++j){
                min += Math.min(cnt1[i][j],cnt2[i][j]);
                max += Math.max(cnt1[i][j],cnt2[i][j]);
            }
        }
        
        return max == 0 ? 65536 : min*65536/max;
    }
    
    private boolean check(char c){
        return c<'a' || c>'z';
    }
}