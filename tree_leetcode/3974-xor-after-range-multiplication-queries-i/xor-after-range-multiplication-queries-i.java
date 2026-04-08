class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1_000_000_007;
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            long v = query[3];
            
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) ((nums[i] * v) % MOD);
            }
        }
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}