import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        Word[] temp = new Word[size];
        for(int i=0;i<size;++i){
            int idx = 0;
            String now = files[i];
            while(now.charAt(idx)<'0'||now.charAt(idx)>'9'){
                idx++;
            }
            String head = now.substring(0,idx).toLowerCase();
            String number = "";
            boolean tf = true;
            while(now.charAt(idx)>='0'&&now.charAt(idx)<='9'){
                number = number + now.charAt(idx);
                idx++;
                if(idx==now.length()) break;
            }
            temp[i] = new Word(i,head,Integer.parseInt(number));
        }
        
        Arrays.sort(temp);
        String[] answer = new String[size];
        for(int i=0;i<size;++i){
            answer[i] = files[temp[i].idx];
        }
        return answer;
    }
}

class Word implements Comparable<Word>{
    int idx;
    String head;
    int number;
    
    public Word(int idx, String head,int number){
        this.idx = idx;
        this.head = head;
        this.number = number;
    }
    
    public int compareTo(Word o){
        if(this.head.equals(o.head)) return this.number-o.number;
        return this.head.compareTo(o.head);
    }
}