import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int[] arr = new int[words.length];
        Queue<Integer> q = new LinkedList<>();

        for( int i=0; i<words.length; ++i){
            if(arr[i]==0 && diff(begin, words[i])){
                q.add(i);
                arr[i] = 1;
            }
        }

        int idx;
        String word;
        while(!q.isEmpty()){
            idx = q.poll();
            word = words[idx];

            if(word.equals(target))
                return arr[idx];

            for(int i=0; i<words.length; ++i){
                if(arr[i]==0 && diff(word,words[i])){
                    q.add(i);
                    arr[i] = arr[idx]+1;
                }
            }
        }

        return 0;
    }

    private boolean diff(String A, String B){
        int cnt = 0;

        for( int i=0; i<A.length(); ++i){
            if(A.charAt(i) != B.charAt(i))
                cnt++;
            if(cnt>1)
                return false;
        }

        return cnt==1;
    }
}