class Solution {
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0, 0);
        return answer;
    }
    public void dfs(int target, int[] numbers, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++; // 멤버 변수 값 증가
            }
            return;
        }
        int currentNum = numbers[idx];
        
        dfs(target, numbers, sum + currentNum, idx + 1);
        dfs(target, numbers, sum - currentNum, idx + 1);
    }
}