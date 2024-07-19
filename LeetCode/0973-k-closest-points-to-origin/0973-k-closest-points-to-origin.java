class Solution {
    static class Point {
        // 좌표 위치와 거리값을 동시에 저장할 클래스
        private final int[] point;
        private final int distance; // x, y 좌표값이 최대 10^4 이므로 제곱해서 계산하더라도 10^8, int로 지정
        
        public Point(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    public int euclideanDistance(int a, int b) {
        return a * a + b * b;
    }

    public int[][] kClosest(int[][] points, int k) {
        // 계산해서
        // 우선순위 큐에 넣은 뒤
        // k 갯수만큼 추출
        PriorityQueue<Point> pointQueue = new PriorityQueue<>(Comparator.comparingInt(d -> d.distance));
        for (int[] point : points) {
            int distance = euclideanDistance(point[0], point[1]);
            pointQueue.add(new Point(point, distance));
        }

        int[][] output = new int[k][];
        for (int i = 0; i < k; i++) {
            output[i] = pointQueue.poll().point;
        }
        return output;
    }
}