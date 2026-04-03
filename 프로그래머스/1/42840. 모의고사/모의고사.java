import java.util.*;
class Solution {
    private final int[] surrender1 = {1,2,3,4,5};
    private final int[] surrender2 = {2,1,2,3,2,4,2,5};
    private final int[] surrender3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int cnt1 = 0, cnt2 = 0, cnt3= 0;
        for(int i=0; i<answers.length; ++i){
            if(answers[i]==surrender1[i%5])
                cnt1++;
            if(answers[i]==surrender2[i%8])
                cnt2++;
            if(answers[i]==surrender3[i%10])
                cnt3++;
        }
        int max = Math.max(Math.max(cnt1,cnt2),cnt3);
        List<Integer> list = new ArrayList<>();
        if(max==cnt1) list.add(1);
        if(max==cnt2) list.add(2);
        if(max==cnt3) list.add(3);
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); ++i)
            ans[i] = list.get(i);
        return ans;
    }
}