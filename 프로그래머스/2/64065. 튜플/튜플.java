//튜플
import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2);
        s = s.replace("},{","/");
        String str[] = s.split("/");
        Arrays.sort(str,(o1,o2)->{
            return Integer.compare(o1.length(), o2.length());
        });
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int n;
        for(String tuple : str){
            String[] numString = tuple.split(",");
            for(int i = 0; i<numString.length; ++i){
                n = Integer.parseInt(numString[i]);
                if(!set.contains(n)){
                    set.add(n);
                    answer.add(n);
                }
            }
        }
                
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}