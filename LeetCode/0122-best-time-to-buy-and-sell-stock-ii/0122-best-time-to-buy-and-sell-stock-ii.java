class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prev = prices[0], current = 0, next = 0;

        // 이전보다 낮으면 prev 갈아치우기
        // 이전보다 높은데 다음 요소가 또 높으면 prev 유지
        // 이전보다 높은데 다음 요소가 낮으면 팔고 prev 갱신
        for (int i = 1; i < prices.length - 1; i++) {
            current = prices[i];
            next = prices[i + 1];
            if (prev > current) {
                prev = current;
            } else if (current > next) {
                maxProfit += current - prev;
                prev = current;
            }
        }
        int last = prices[prices.length - 1];
        if (last > prev) {
            maxProfit += last - prev;
        }
        return maxProfit;
    }
}