class Solution {
    /*
    * 가장 많은 작업을 하는 요소의 작업 횟수와, 해당 작업 횟수를 가진 요소의 개수를 구해서 계산하는 방법
    * 1. 가장 많은 작업을 하는 횟수 i, i번 작업을 하는 요소 a개(EX, AAABBC, i=3, a=1(A혼자 최대 3번)
    * 2. n번의 간격을 둔다 -> 특정 요소+n이 1개의 cycle
    * 3. 가장 많은 작업을 하는 횟수 i번이 있을 때, i-1 * n+1 번의 작업시간은 기본으로 발생함.(n+1 -> 1 cycle의 구성 개수)
    * 4. 그리고 마지막 set에서 i번 작업하는 task만 남아서 마무리됨.
    * 5. 식 : (i-1)*(n+1)+a
    * */
    public int leastInterval(char[] tasks, int n) {
        // 1. 각 작업의 빈도 수를 계산
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        // 2. 가장 많이 실행된 작업의 빈도를 찾음
        Arrays.sort(taskCounts);
        int maxFreq = taskCounts[25]; // 가장 높은 빈도 (최대 값)

        // 3. 가장 많이 나온 작업과 같은 빈도를 가진 작업의 개수 계산
        int maxCount = (int) Arrays.stream(taskCounts).filter(value -> value==maxFreq).count();

        // 4. 최소 실행 시간을 계산
        int minimumTime = (maxFreq - 1) * (n + 1) + maxCount;

        // 5. 전체 작업의 개수와 최소 시간을 비교하여 반환
        return Math.max(minimumTime, tasks.length);
    }
}