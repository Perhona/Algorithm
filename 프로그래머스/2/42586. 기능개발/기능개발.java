import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // queue를 이용해 배포 그룹 만들어주기
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0;i<progresses.length;i++) {
            int todo = (100 - progresses[i]);
            int remainDay = (int) Math.ceil((double) todo / speeds[i]);
            
            // 이전 일수보다 남은 일수가 많으면 배포 그룹 클리어
            if (!queue.isEmpty() && queue.peek() < remainDay) {
                answer.add(queue.size());
                queue.clear();
            }
            queue.offer(remainDay);
        }
        
        answer.add(queue.size()); // 마지막 배포 그룹 클리어

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}