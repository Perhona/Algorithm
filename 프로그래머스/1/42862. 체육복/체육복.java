import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] nums = new int[n+1];
        for (int a : lost) {
            nums[a]--;
        }
        for (int a : reserve) {
            nums[a]++;
        }
        
        int answer = 0;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] >= 0) {
                answer++;
                continue;
            }
            
            if (nums[i] == -1 && i != nums.length-1) {
                int prev = nums[i-1];
                int next = nums[i+1];
                if (prev == 1) {
                    nums[i] = 0;
                    nums[i-1] = 0;
                    answer++;
                } else if (next == 1) {
                    nums[i] = 0;
                    nums[i+1] = 0;
                    answer++;
                }
            }
            
            if (i == nums.length-1) {
                int prev = nums[i-1];
                if (prev == 1) {
                    nums[i] = 0;
                    nums[i-1] = 0;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}