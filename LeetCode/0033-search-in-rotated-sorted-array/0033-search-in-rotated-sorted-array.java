import java.util.OptionalInt;
import java.util.stream.IntStream;

class Solution {
    public int search(int[] nums, int target) {
        int[] originalNums = Arrays.copyOf(nums, nums.length); // nums 복사

        Arrays.sort(nums); // 정렬
        int idx = bfs(nums, 0, (nums.length - 1) / 2, nums.length -1, target); // target의 정렬된 경우 index 찾기
        return idx == -1 ? -1 : IntStream
                .range(0, originalNums.length)
                .filter(i -> originalNums[i] == nums[idx])
                .findFirst()
                .getAsInt(); // 원래 배열에서 nums[idx]의 위치 찾기
    }

    private int bfs(int[] nums, int left, int mid, int right, int target) {
        if (left > right) {   // left와 right가 엇갈리면 종료
            return -1;
        }

        if (nums[mid] < target) {     // 중앙값보다 target이 큰 경우
            return bfs(nums, mid + 1, (mid + 1 + right) / 2, right, target);
        } else if (target < nums[mid]) {    // 중앙값보다 target이 작은 경우
            return bfs(nums, left, (left + mid - 1) / 2, mid - 1, target);
        } else {    // 중앙값과 target이 같은 경우 mid index 리턴
            return mid;
        }
    }
}