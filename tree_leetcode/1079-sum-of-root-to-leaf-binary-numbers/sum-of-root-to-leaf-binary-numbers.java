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

    int total = 0;   // global answer

    public int sumRootToLeaf(TreeNode root) {

        List<Integer> path = new ArrayList<>();  
        dfs(root, path);                         

        return total;
    }

    private void dfs(TreeNode node, List<Integer> path) {

        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {

            int number = 0;

            for (int bit : path) {
                number = number * 2 + bit;
            }

            total += number;
        }
        else {
            dfs(node.left, path);
            dfs(node.right, path);
        }

        path.remove(path.size() - 1);
    }
}