/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 시작 지점인 head와 계속해서 바뀔 pointer 노드 선언
        ListNode head;
        ListNode pointer = new ListNode();
        head = pointer;

        // 10 이상 여부를 저장
        boolean isOverTen = false;
        
        // 두 연결 리스트가 모두 null이 될 때 까지 반복
        // 전체 값을 int로 변환하려는게 아니라 각 노드 값을 변환하고 계산하는 방식으로 변경함
        while (l1 != null || l2 != null) {
            // 각 노드의 val값 추출
            int p = l1 == null ? 0 : l1.val;
            int q = l2 == null ? 0 : l2.val;
        
            // 이전 값이 10 이상이었다면 sum에 1을 더해서 10으로 나눈 나머지 계산 후 현재 값에 연결
            int sum = p + q + (isOverTen ? 1 : 0);
            pointer.next = new ListNode((sum % 10));
        
            // 이 때 전체 이전 값의 10 이상 여부까지 합친 sum으로 또다시 10이 넘는지 확인
            isOverTen = sum >= 10;
            
            // pointer 다음 노드로 변경
            pointer = pointer.next;
            
            // l1, l2 다음 노드로 변경
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 반복을 끝냈음에도 isOverTen이 true라면 마지막 노드값이 10이었으므로 노드 1 연결
        if (isOverTen)
            pointer.next = new ListNode(1);

        return head.next;
    }
}