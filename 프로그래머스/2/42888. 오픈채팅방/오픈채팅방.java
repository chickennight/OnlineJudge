//오픈채팅방
import java.util.*;
class Solution {
    private List<String> answer;
    private Map<String, String> map;
    public String[] solution(String[] record) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        for(String order: record)
            inputUser(order);
        
        for(String order: record)
            generateMessage(order);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    private void inputUser(String order){
        String[] orders = order.split(" ");
        if(orders[0].equals("Enter"))
            map.put(orders[1],orders[2]);
        else if(orders[0].equals("Change"))
            map.put(orders[1],orders[2]);
    }
    
    private void generateMessage(String order){
        String[] orders = order.split(" ");
        if(orders[0].equals("Enter"))
            answer.add(map.get(orders[1])+"님이 들어왔습니다.");
        else if(orders[0].equals("Leave"))
            answer.add(map.get(orders[1])+"님이 나갔습니다.");
    }
}