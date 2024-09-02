/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.putIfAbsent(inorder[i], i);
        }
        return dfs(preorder, 0, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        // 1. 현재 트리의 루트 노드 찾기
        // 2. 왼쪽 노드 찾기 - 전위순회에서는 NLR 이므로 preStart는 +1씩, 중위 순회에서는 종료 idx가 순차적으로 좁혀진다.
        // 3. 오른쪽 노드 찾기 - NLR이므로 preStart는 발견한 중위순회 idx(좌측노드 갯수) + 1부터 탐색, 중위순회에서는 시작
        // idx에서 좁혀간다.
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart]; // 현재 트리의 루트 값
        TreeNode root = new TreeNode(rootVal);
        int rootInIdx = inorderMap.get(rootVal); // 중위 순회에서 좌측 노드의 갯수이자 현재 root 노드의 인덱스

        root.left = dfs(preorder, preStart + 1, inorderMap, inStart, rootInIdx - 1); 
        // 전위 순회는 +1부터, 중위 순회는 end값 제한
        root.right = dfs(preorder, preStart + rootInIdx - inStart + 1, inorderMap, rootInIdx + 1, inEnd); 
        // 전위 순회는 현재 범위 중위 순회에서 발견한 좌측 노드 갯수 + 1부터, 중위순회는 start값 제한

        return root;
    }
}