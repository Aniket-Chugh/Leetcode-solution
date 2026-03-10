class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        
        // dp[i][j][0] = valid arrays with i zeros, j ones, ending in 0
        // dp[i][j][1] = valid arrays with i zeros, j ones, ending in 1
        int[][][] dp = new int[zero + 1][one + 1][2];
        
        // Base cases: single streaks up to the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // Appending a 0
                // We use (long) to prevent integer overflow before applying modulo
                long waysEndingIn0 = (long) dp[i - 1][j][0] + dp[i - 1][j][1];
                dp[i][j][0] = (int) (waysEndingIn0 % MOD);
                
                if (i > limit) {
                    // + MOD prevents negative values during subtraction
                    dp[i][j][0] = (int) ((dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD);
                }
                
                // Appending a 1
                long waysEndingIn1 = (long) dp[i][j - 1][0] + dp[i][j - 1][1];
                dp[i][j][1] = (int) (waysEndingIn1 % MOD);
                
                if (j > limit) {
                    dp[i][j][1] = (int) ((dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD);
                }
            }
        }
        
        return (int) (((long) dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}