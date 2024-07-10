import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i < skill.length(); ++i)
            map.put(skill.charAt(i),map.size()+1);
        
        int answer = 0, cnt;
        String skillTree;
        boolean tf;
        char c;
        for(int i=0;i<skill_trees.length; ++i){
            
            skillTree = skill_trees[i];
            tf = true;
            cnt = 0;
            
            for(int j=0; j<skillTree.length(); ++j){
                c = skillTree.charAt(j);
                if(map.containsKey(c)){
                    if(map.get(c)==cnt+1)
                        ++cnt;
                    else {
                        tf = false;
                        break;
                    }
                }         
            }
            
            if(tf) ++answer;
        }
        
        return answer;
    }
}