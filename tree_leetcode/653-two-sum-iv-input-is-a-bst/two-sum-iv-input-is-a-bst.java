class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) return false;

        // Check if complement exists
        if (set.contains(k - node.val)) {
            return true;
        }

        // Add current value
        set.add(node.val);

        // Search left and right
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}