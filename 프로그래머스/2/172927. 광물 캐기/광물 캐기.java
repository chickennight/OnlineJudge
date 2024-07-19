import java.util.*;

class Solution {
        
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] score = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int totalPicks = 0;
        for(int num : picks) totalPicks += num;
        
        List<Mineral> list = new ArrayList<>();
        for(int i = 0; i < minerals.length; i+=5) {
            if(totalPicks == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; ++j) {
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                int target = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0;
                
                dia += score[0][target];
                iron += score[1][target];
                stone += score[2][target];
            }
            
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }
        
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        for(Mineral m : list) {
            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
            }else if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
            }else if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
}

class Mineral {
    int dia, iron, stone;
        
    public Mineral(int dia, int iron, int stone) {
        this.dia = dia;
        this.iron = iron;
        this.stone = stone;
    }
}