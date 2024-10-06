import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
       long left = 1;
        long right = (long) times[times.length - 1] * n;
//        long mid = left + ((right - left) / 2);
//        boolean isMultiple = isMultiple(mid, n, times);

        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long findN = findN(mid, times);
//            isMultiple = isMultiple(mid, n, times);
            if (findN < n) {
                left = mid + 1;
            } else if (n <= findN
//                    || !isMultiple
            ) {
                right = mid - 1;
            }
        }
        return left;
    }
    public long findN(long mid, int[] times) {
        long result = 0;
        for (long i : times) {
            result += mid / i;
        }
        return result;
    }
}