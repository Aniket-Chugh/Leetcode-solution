class Solution {
    public double findMaxAverage(int[] nums, int k) {

        if (nums.length < k) return 0.0;

        double sum = 0;

        // 1. Build the first sliding window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

        // 2. Slide the window from index k to end
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];      // add new element
            sum -= nums[i - k];  // remove old element
            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }
}
