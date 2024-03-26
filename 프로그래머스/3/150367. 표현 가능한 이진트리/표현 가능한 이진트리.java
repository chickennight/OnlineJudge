import java.util.*;
class Solution {
    
    static boolean tf;
    static boolean[] arr;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        int size,length,pow;
        long n;
        for (int i=0; i<numbers.length; ++i) {
            n = numbers[i];
 
            String b = Long.toBinaryString(n);
            length = b.length();
            
            pow = 1;
            size = (int)Math.pow(2,pow)-1;

            while (size<length) {
                size = (int) Math.pow(2,pow++)-1;
            }

            arr = new boolean[size];
            int idx = size-length;
            for(int j=0; j<length; ++j) {
                arr[idx++]=(b.charAt(j) == '1');
            }

            tf = true;
            isCorrect(false,0,size-1);
            answer[i]=tf?1:0;
        }
        return answer;

    }

    public static void isCorrect(boolean finished, int s, int e) {
        int mid = (s+e)/2;
        if(finished&&arr[mid]){
            tf=false;
            return;
        }

        if(s<e){
            isCorrect(!arr[mid],s,mid-1); 
            isCorrect(!arr[mid],mid+1,e); 
        }

    }
}