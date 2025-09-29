// Student-style simple solution (O(n))
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            // check left and right neighbors safely
            boolean leftSame = (i - 1 >= 0 && nums[i] == nums[i - 1]);
            boolean rightSame = (i + 1 < nums.length && nums[i] == nums[i + 1]);
            if (!leftSame && !rightSame) {
                return nums[i];
            }
        }
        // fallback (shouldn't happen given constraints)
        return -1;
    }
}
