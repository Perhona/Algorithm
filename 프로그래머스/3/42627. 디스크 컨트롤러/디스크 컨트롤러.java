import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int[][] extendedJobs = new int[jobs.length][3];
        for (int i=0;i<jobs.length;i++) {
            extendedJobs[i][0] = jobs[i][0];    // 요청 시간
            extendedJobs[i][1] = jobs[i][1];    // 소요 시간
            extendedJobs[i][2] = i;             // 작업 번호
        }
        // 요청 시간 오름차순 정렬
        Arrays.sort(extendedJobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        // 우선순위 큐 (소요 시간 짧은 -> 요청 시간 빠른 -> 작업 번호 작은 순 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // 소요 시간 기준
            } else if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // 요청 시간 기준
            } else {
                return Integer.compare(a[2], b[2]); // 작업 번호 기준
            }
        });
        
        int currentTime = 0;    // 현재 시간
        int totalTime = 0;      // 전체 소요 시간
        int jobIndex = 0;       // 작업 순서
        int completedJobs = 0;  // 작업 완료 건수
        
        while(completedJobs < jobs.length) { // 작업이 모두 완료될 때까지
            while(jobIndex < extendedJobs.length && extendedJobs[jobIndex][0] <= currentTime) { // 요청 시간이 현재 시간 이하일 때 큐 삽입 및 인덱스 증가
                pq.offer(extendedJobs[jobIndex]);
                jobIndex++;
            }
            
            // 큐에 있는 작업 처리
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime = currentTime + job[1];
                totalTime += currentTime - job[0];
                completedJobs++;
            } else { // 작업 요청이 (큐에)없으면 다음 작업 요청 시간으로 이동
                currentTime = extendedJobs[jobIndex][0];
            }
        }
        
        return totalTime / jobs.length;
    }
}