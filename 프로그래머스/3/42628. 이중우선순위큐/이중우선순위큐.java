import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();

        for (String s : operations) {
            dpq.operate(s);
        }

        return dpq.get();
    }

    private static class DoublePriorityQueue {
        private final PriorityQueue<Integer> minPq;
        private final PriorityQueue<Integer> maxPq;

        public DoublePriorityQueue() {
            this.minPq = new PriorityQueue<>();
            this.maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void operate(String operation) {
            String o = operation.split(" ")[0];
            Integer n = Integer.valueOf(operation.split(" ")[1]);
            if (o.equals("I")) {
                minPq.add(n);
                maxPq.add(n);
            }
            if (o.equals("D")) {
                if (n < 0) {
                    maxPq.remove(minPq.poll());
                } else {
                    minPq.remove(maxPq.poll());
                }
            }
        }

        public int[] get() {
            if (minPq.isEmpty()) {
                return new int[]{0, 0};
            } else {
                return new int[]{maxPq.poll(), minPq.poll()};
            }
        }
    }
}