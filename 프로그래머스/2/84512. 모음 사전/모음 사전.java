import java.util.*;
class Solution {
    
    static String[] charList = {"A","E","I","O","U"};
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        makeList(word, "", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    static void makeList(String word, String input, int depth) {
        
        list.add(input);
        
        if(depth == 5) 
            return;
        
        
        for (int i = 0; i < 5; i++) 
            makeList(word, input + charList[i], depth + 1);
        
    }
}