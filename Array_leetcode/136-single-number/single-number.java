class Solution {
     public int singleNumber(int[] nums) {
        int result = 0;

        // XOR all elements — duplicates cancel out
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}