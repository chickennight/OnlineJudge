// 괄호 회전하기
import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); ++i){
            ans += isCorrect(i,s);
        }
        return ans;
    }
    
    private int isCorrect(int start, String s){
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        
        char c;
        for(int i=0; i<size; ++i){
            c = s.charAt((i+start)%size);
            if(c == '[' || c == '{' || c == '('){
                stack.add(c);
            }else{
                if(stack.isEmpty()) return 0;
                switch (c){
                    case ']':
                        if(stack.peek()=='[') stack.pop();
                        else return 0;
                        break;
                    case '}':
                        if(stack.peek()=='{') stack.pop();
                        else return 0;
                        break;
                    case ')':
                        if(stack.peek()=='(') stack.pop();
                        else return 0;
                        break;
                }
            }
        }
        
        if(!stack.isEmpty()) return 0;
        
        return 1;
    }
}