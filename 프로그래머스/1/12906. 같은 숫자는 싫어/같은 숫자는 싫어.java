import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int size = 1;
        stack.push(arr[arr.length-1]);
        for(int i=arr.length-2; i>=0; --i)
            if(arr[i]!=stack.peek()){
                stack.push(arr[i]);
                size++;
            }
        
        int[] answer = new int[size];
        for(int i=0; i<size; ++i)
            answer[i] = stack.pop();

        return answer;
    }
}