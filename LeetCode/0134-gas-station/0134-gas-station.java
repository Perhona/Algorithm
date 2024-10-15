class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<int[]> existGasList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            existGasList.add(new int[]{i, diff});
            sum += diff;
        }
        if (sum < 0) {
            return -1;
        }

        Queue<int[]> gasQueue = new ArrayDeque<>(existGasList);
        List<int[]> usedGasList = new ArrayList<>();
        int[] result = new int[]{-1, 0};

        while (!gasQueue.isEmpty()) {
            int[] current = gasQueue.poll();
            usedGasList.add(current);

            if (result[0] == -1) {
                result[0] = current[0];
            }
            result[1] += current[1];

            // 잔여 가스가 0 이하이면 사용했던 가스 다시 큐에 add 후 재시쟉
            if (result[1] <= 0 && usedGasList.size() != existGasList.size()) {
                result[0] = -1;
                result[1] = 0;
                gasQueue.addAll(usedGasList);
                usedGasList.clear();
            }
        }
        return result[0];
    }
}