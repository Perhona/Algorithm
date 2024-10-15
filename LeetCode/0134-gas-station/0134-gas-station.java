class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<int[]> existGasList = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            existGasList.add(new int[]{i, gas[i] - cost[i]});
        }
        Queue<int[]> gasQueue = new ArrayDeque<>(existGasList);
        int[] result = new int[]{-1, 0};
        int count = existGasList.size();

        while (!gasQueue.isEmpty()) {
            if (count <= 0 && result[1] == 0) {
                return -1;
            }

            int[] current = gasQueue.poll();
            count--;

            if (result[0] == -1) {
                result[0] = current[0];
            }
            result[1] += current[1];
            if (result[1] <= 0 && !gasQueue.isEmpty()) {
                result[0] = -1;
                result[1] = 0;
                gasQueue.add(current);
            }
        }
        return result[0];
    }
}