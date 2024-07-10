import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> feeMap = new TreeMap<>();
        Map<String, String> inRecords = new HashMap<>();
        
        for(String record : records)
            feeMap.put(record.split(" ")[1], 0);
        
        for(String record : records){
            String[] infos = record.split(" ");
            String time = infos[0];
            String num = infos[1];
            String action = infos[2];
            
            if(action.equals("IN")){
                inRecords.put(num, time);
            }else{
                int parkingTime = convert(time) - convert(inRecords.remove(num));
                feeMap.put(num, feeMap.get(num) + parkingTime);
            }
        }
        
        for(String num : inRecords.keySet()) {
            int parkingTime = convert("23:59") - convert(inRecords.get(num));
            feeMap.put(num, feeMap.get(num) + parkingTime);
        }
        
        int[] answer = new int[feeMap.size()];
        int index = 0;
        for(Map.Entry<String, Integer> entry : feeMap.entrySet()){
            int totalTime = entry.getValue();
            if(totalTime > fees[0]){
                answer[index++] = fees[1] + (int)Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[index++] = fees[1];
            }
        }
        
        return answer;
    }
    
    private int convert(String time){
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}