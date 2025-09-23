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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> answer = new ArrayList<>();

        if (root == null) return answer; // null case -> empty list

        // Left subtree traversal ka result leke add kar do
        answer.addAll(inorderTraversal(root.left));

        // Current node ka value
        answer.add(root.val);

        // Right subtree traversal ka result leke add kar do
        answer.addAll(inorderTraversal(root.right));

        return answer;



    }
}