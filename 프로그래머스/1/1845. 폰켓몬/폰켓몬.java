import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int half = nums.length / 2;
        Set<Integer> monSet = new HashSet<>();
        for (int n : nums) {
            monSet.add(n);
        }
        
        return Math.min(half, monSet.size());
    }
}