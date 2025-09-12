class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Check every pair of numbers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Never reached because one solution is guaranteed
        return new int[]{-1, -1};
    }
}
