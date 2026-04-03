import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int size = arr.length/2+1;
        char[] operations = new char[size - 1];
        int[] numbers = new int[size];
        
        int[][] max = new int[size][size];
        int[][] min = new int[size][size];

        init(min, max, size);
        setting(arr, numbers, operations);

        for(int d=0; d<numbers.length; ++d){
            for(int i=0; i<numbers.length-d; ++i){
                int j = i + d;
                if(i == j){
                    max[i][j] = numbers[i];
                    min[i][j] = numbers[i];
                    continue;
                }

                for(int k=i; k<j; ++k){
                    calculate(operations, max, min, i, j, k);
                }
            }
        }

        return max[0][numbers.length - 1];
    }

    private void calculate(char[] opers, int[][] max, int[][] min, int i, int j, int k) {
        if(opers[k] == '+') {
            max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
            min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
            return;
        }
        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
    }

    private void init(int[][] min, int[][] max, int size){
        for(int i=0; i<size; ++i){
            for(int j=0; j<size; ++j){
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private void setting(String[] arr, int[] nums, char[] opers){
        for(int i=0; i<arr.length; ++i){
            if(i%2 == 0)
                nums[i/2] = Integer.parseInt(arr[i]);
            else
                opers[i/2] = arr[i].charAt(0);
            
        }
    }
}