import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i=0;i<progresses.length;i++) {
            int todo = (100 - progresses[i]);
            days[i] = (int) Math.ceil((double) todo / speeds[i]);
        }

        Deque<Integer> answer = new ArrayDeque<>();
        answer.offer(1);
        int lastTodo = days[0];
        
        for (int i=1;i<days.length;i++) {
            if (days[i] <= lastTodo) {
                answer.offer(answer.pollLast() + 1);
            } else {
                lastTodo = days[i];
                answer.offer(1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}