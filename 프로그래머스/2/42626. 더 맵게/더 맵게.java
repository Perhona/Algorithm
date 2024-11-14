import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // scoville 배열의 모든 수는 K 이상이 되어야 한다.
        // 가장 작은 값 + 다음 값*2로 새롭게 만들 수 있다.
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.add(n);
        }
        
        while(!pq.isEmpty()) {
            int n = pq.poll();
            if (n >= K) {
                return count;
            }
            
            if(pq.isEmpty()) {
                return -1;
            }
            
            pq.add(n + pq.poll()*2);
            count++;
        }
        
        return -1;
    }
}