import java.util.*;

class Solution {
    public String solution(String s) {
        boolean tf = true;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(c == ' '){
                tf = true;
                sb.append(' ');
            }else{
                if(tf){
                    if('a'<=c && c<='z')
                        sb.append((char)('A'+c-'a'));
                    else
                        sb.append(c);
                    tf = false;
                }else{
                    if('A'<=c && c<='Z')
                        sb.append((char)('a'+c-'A'));
                    else
                        sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}