class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 스택이 비어있지 않고 스택에 저장된 값이 현재 온도값보다 낮으면
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 스택에서 해당 인덱스 값을 꺼내서 인덱스 값 간의 차 저장
                int prevIdx = stack.pop();
                answer[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return answer;
    }
}