// 3차 압축
import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        for(int i=0; i<26; ++i) dic.put(String.valueOf((char)('A'+i)),i+1);
        
        List<Integer> ans = new ArrayList<>();
        
        int idx = 0;
        while(idx < msg.length()){
            String str = "";
            
            while(idx < msg.length()){
                if(dic.containsKey(str+msg.charAt(idx)))
                    str += msg.charAt(idx);
                else 
                    break;
                idx++;
            }
            
            ans.add(dic.get(str));
 
            if (idx < msg.length()) 
                dic.put(str+msg.charAt(idx), dic.size()+1);
            
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}