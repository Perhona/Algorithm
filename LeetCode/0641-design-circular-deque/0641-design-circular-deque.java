class MyCircularDeque {
    // null 활용을 위해 Integer 배열 사용
    private Integer[] array;
    // 끝 인덱스, 첫 시작 시 -1

    private int rear = -1;

    public MyCircularDeque(int k) {
        array = new Integer[k];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        // 끝 인덱스 + 1 부터 공간을 확보하여 앞선 값 저장
        for (int i = rear + 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        rear++;
        array[0] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        // rear 위치를 먼저 이동시키고 삽입
        array[++rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        // 앞의 값이 필요 없으므로 순회하면서 뒤의 값 저장
        for (int i = 0; i < rear; i++) {
            array[i] = array[i + 1];
        }

        // 가리키던 마지막 값 null 처리
        array[rear--] = null;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        array[rear--] = null;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[0];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[rear];
    }

    public boolean isEmpty() {
        return array[0] == null;

    }

    public boolean isFull() {
        return rear == array.length - 1;

    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */