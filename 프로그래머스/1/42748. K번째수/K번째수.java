import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i 포함, j 포함
        // 1. commands를 순회하면서 i~j까지 자른다. 
        // 2. 자른 숫자 내에서 정렬 후 k번째 숫자를 배열에 넣는다.
        
        int[] answer = new int[commands.length];
        // 1. commands 순회
        for (int x=0;x < commands.length;x++){
            // i, j, k 정의
            int i = commands[x][0]; 
            int j = commands[x][1]; 
            int k = commands[x][2]; 
            
            // 복사할 배열 정의 & i~j까지 복사
            int[] splitedArr = new int[j-i+1];
            int idx=0;
            for (int y=i-1;y<j;y++){
                splitedArr[idx] = array[y];
                idx++;
            }
            Arrays.sort(splitedArr);
            answer[x] = splitedArr[k-1];
        }
        return answer;
    }
}