import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int cnt = 0;
        int[] answer = {};

        String prev = String.valueOf(words[0].charAt(0));
        for(String s: words){
            if(set.contains(s) || s.charAt(0) != prev.charAt(prev.length()-1)){
                break;
            }else{
                prev = s;
                set.add(s);
                cnt++;
            }
        }

        return cnt==words.length ? new int[]{0,0} : new int[]{cnt%n+1,cnt/n+1};
    }
}