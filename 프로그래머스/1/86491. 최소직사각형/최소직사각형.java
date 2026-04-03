import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int[] size: sizes){
            Arrays.sort(size);
            w = Math.max(w,size[0]);
            h = Math.max(h,size[1]);
        }
        return w*h;
    }
}