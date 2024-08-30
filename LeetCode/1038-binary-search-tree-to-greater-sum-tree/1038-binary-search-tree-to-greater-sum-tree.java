/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        // 모든 노드 순회
        // 자기 자신을 포함해서 자기보다 큰 노드의 값을 모두 더하기
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        // 탐색 종료 조건
        if (node == null) {
            return;
        }

        // 오른쪽 노드를 먼저 순회
        dfs(node.right);

        // 오른쪽 노드 탐색이 종료되면 sum에 자신의 값 더하기
        sum += node.val;
        // 자기 자신의 값도 최종 sum으로 업데이트
        node.val = sum;

        // 좌측 노드 탐색
        dfs(node.left);
    }
}