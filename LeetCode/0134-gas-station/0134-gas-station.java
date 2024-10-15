class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 갈 수 없는 경우(gas량 보다 cost가 큰 경우) 
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int fuel = 0;
        int startIdx = 0;
        
        // 한 번만 순회하면서 기존 gas양과 gas-cost 더하기
        // 더한 값이 0 이하인 경우 기존 gas(fuel) 0으로 리셋 및 시작 인덱스 다음으로 설정
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            if (fuel + diff < 0) {
                startIdx = i + 1;
                fuel = 0;
            } else {
                fuel += diff;
            }
        }

        return startIdx;
    }
}