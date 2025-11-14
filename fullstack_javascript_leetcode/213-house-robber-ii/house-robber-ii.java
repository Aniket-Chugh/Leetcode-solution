class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // Case 1: Rob houses 0 → n-2
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob houses 1 → n-1
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prevNot = 0;  // max money if previous house NOT robbed
        int prevRob = 0;  // max money if previous house robbed

        for (int i = start; i <= end; i++) {
            int curr = nums[i];

            int newNot = Math.max(prevNot, prevRob);
            int newRob = prevNot + curr;

            prevNot = newNot;
            prevRob = newRob;
        }

        return Math.max(prevNot, prevRob);
    }
}
