import java.util.*;
class Solution {
    private List<int[]> arr;

    public int[][] solution(int n) {
        arr = new ArrayList<>();
        move(n, 1, 2, 3);
        return arr.stream().toArray(int[][]::new);
    }

    private void move(int cnt, int start, int mid, int end) {
        if (cnt == 0) 
            return;
    
        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }
}