class Solution {
    public int findKthLargest(int[] nums, int k) {
        BinaryHeap bh = new BinaryHeap();
        bh.add(nums);
        int result = 0;
        for (int i=0;i<k;i++){
            result = bh.extract();
        }
        return result;
    }

    private static class BinaryHeap {

        private List<Integer> elems = new ArrayList<>();

        public BinaryHeap() {
            elems.add(0, null);
        }

        public int extract() {  // 값을 추출할 땐 맨 처음 값을 맨 마지막 값으로 대체(추가)하므로 Down 연산 수행
            int extracted = elems.get(1);

            elems.set(1, elems.get(elems.size() - 1));
            elems.remove(elems.size() - 1);

            maxHeap(1);
            return extracted;
        }

        public void add(int[] nums) {   // 값을 추가할 땐 맨 마지막에 추가되므로 Up 연산 수행
            for (int n : nums) {
                elems.add(n);
                percolateUp();
            }
        }

        private void swap(int i, int j) {
            int tempValue = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, tempValue);
        }

        private void percolateUp() { // up 연산
            int idx = elems.size() - 1;
            // 부모랑 비교 후 자리 변경
            int parentIdx = idx / 2;

            while (parentIdx > 0) {
                if (elems.get(parentIdx) < elems.get(idx)) {
                    // 자식 노드 위치, 부모 노드 위치 변경
                    swap(idx, parentIdx);
                }
                idx = parentIdx;
                parentIdx = idx / 2;
            }
        }

        private void maxHeap(int i) {    // down 연산
            int leftIdx = i * 2;
            int rightIdx = i * 2 + 1;
            int largestIdx = i;

            if (leftIdx <= elems.size() - 1 && elems.get(leftIdx) > elems.get(largestIdx)) {
                largestIdx = leftIdx;
            }
            if (rightIdx <= elems.size() - 1 && elems.get(rightIdx) > elems.get(largestIdx)) {
                largestIdx = rightIdx;
            }
            if (largestIdx != i) {
                swap(largestIdx, i);
                maxHeap(largestIdx);
            }
        }
    }
}