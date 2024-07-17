/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
           // 예외처리
        if (head == null || left == right) return head;

        // left가 1인 경우, 노드 시작점 관리를 위해 dummy 노드 생성
        ListNode dummy = new ListNode(0, head);

        // 역순 직전 노드 찾기
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode end = pre.next;
        ListNode curr = end.next;

        // end 노드가 right지점에 가서 다음 노드와 연결되고, curr노드는 맨 앞으로 옮겨줌
        for (int i = left; i < right; i++) {
            end.next = curr.next;
            // curr.next = end;
            curr.next = pre.next;
            pre.next = curr;
            curr = end.next;
        }
        return dummy.next;
    }
}