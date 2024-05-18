import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(String order: operations){
            query(order, map);
        }
        if(map.size()==0) return new int[]{0,0};
        else{
            return new int[]{map.lastKey(),map.firstKey()};
        }
    }
    
    private void query(String order, TreeMap<Integer,Integer> map){
        String[] input = order.split(" ");
        String id = input[0];
        int value = Integer.parseInt(input[1]);
        if(id.equals("I")){
            map.put(value,map.getOrDefault(value,0)+1);
        }else {
            if(map.size()==0) return;
            if(value==1){
                int cnt = map.get(map.lastKey());
                if(cnt == 1) map.remove(map.lastKey());
                else map.put(map.lastKey(),cnt-1);
            }else{
                int cnt = map.get(map.firstKey());
                if(cnt == 1) map.remove(map.firstKey());
                else map.put(map.firstKey(),cnt-1);
            }
        }

    }
}