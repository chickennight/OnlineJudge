import java.util.*;

class Solution {
    private class Number{
        int num;
        public Number(int num){
            this.num = num;
        }
    }
    public int[] solution(String[] operations) {
        TreeSet<Number> set = new TreeSet<>((o1,o2)->{
            return o1.num-o2.num;
        });
        String[] order;
        int n;
        for(int i=0; i<operations.length; ++i) {
            order = operations[i].split(" ");
            n = Integer.parseInt(order[1]);
            if(order[0].equals("I"))
                set.add(new Number(n));
            else{
                if(!set.isEmpty()){
                    if(n==1) set.pollLast();
                    else set.pollFirst();
                }
            }
        }

        
        int[] answer = new int[2];
        if(!set.isEmpty()){
            answer[0] = set.last().num;
            answer[1] = set.first().num;
        }

	    return answer;
    }
}