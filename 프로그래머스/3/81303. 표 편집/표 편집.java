import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> order = new Stack<Integer>();
        
        int size = n;
        
        for(int i=0; i<cmd.length; ++i) {
            char c = cmd[i].charAt(0);
            if(c == 'D')
                k+=Integer.parseInt(cmd[i].substring(2));
            else if (c == 'U')
                k-=Integer.parseInt(cmd[i].substring(2));
            else if (c == 'C') {
                order.add(k);
                size--;
                if(k == size)
                    k--;
            } else if(c == 'Z') {
                if(order.pop() <= k)
                    k++;
                size++;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<size; ++i)
            builder.append("O");
        while(!order.isEmpty())
            builder.insert(order.pop().intValue(), "X");
        
        return builder.toString();
    }
}