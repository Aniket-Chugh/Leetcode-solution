class Solution {
    
    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        // Calculate tilt
        totalTilt += Math.abs(leftSum - rightSum);

        // Return subtree sum
        return leftSum + rightSum + node.val;
    }
}