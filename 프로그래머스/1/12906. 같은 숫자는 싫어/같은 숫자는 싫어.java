import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        List<Integer> numList = new ArrayList<>();
        numList.add(arr[0]);
        int idx = 0;
        
        for (int i=1;i<arr.length;i++) {
            int prevNum = numList.get(idx);
            if (prevNum != arr[i]) {
                numList.add(arr[i]);
                idx++;
            }
        }
        return numList.stream().mapToInt(i -> i).toArray();
    }
}