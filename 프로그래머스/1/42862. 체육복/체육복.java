import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] nums = new int[n+1];
        int answer = n; // 있는 사람 추가하기가 아니라 없는사람 추려내기로 바꿔보기
        
        // nums 배열에 체육복 유(1)무(-1) 표시
        for (int a : lost) {
            nums[a]--;
        }
        for (int a : reserve) {
            nums[a]++;
        }
        
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == -1) {
                if (nums[i-1] == 1) {
                    nums[i] = 0;
                    nums[i-1] = 0;
                } else if (i < nums.length-1 && nums[i+1] == 1) {
                    nums[i] = 0;
                    nums[i+1] = 0;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}