import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 시간 배열을 오름차순 정렬
        Arrays.sort(times);

        long left = 1;  // 최소 시간 (1분)
        long right = (long) times[times.length - 1] * n;  // 최대 시간 (가장 오래 걸리는 심사관이 모든 사람을 처리할 때)

        // 이진 탐색 시작
        while (left < right) {
            long mid = left + (right - left) / 2;  // 중간 값 계산
            long countN = findN(mid, times);

            if (countN < n) {
                left = mid + 1;  // mid 시간 내에 모든 사람을 처리할 수 없다면, 더 큰 시간이 필요
            } else {
                right = mid;  // mid 시간 내에 모든 사람을 처리할 수 있다면, 더 작은 시간이 가능할 수도 있음
            }
        }
        return left;  // 최소 시간을 반환
    }

    public long findN(long mid, int[] times) {
        long result = 0;
        for (long i : times) {
            result += mid / i;
        }
        return result;
    }
}