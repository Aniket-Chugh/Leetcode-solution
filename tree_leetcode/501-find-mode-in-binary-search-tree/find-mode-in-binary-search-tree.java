class Solution {

    int currentCount = 0;
    int maxCount = 0;
    Integer prev = null;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        
        // Convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Process current node
        if (prev == null || node.val != prev) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(node.val);
        } else if (currentCount == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }
}