class Solution {
    private Integer[][][] memo;
    
    public int minimumDistance(String word) {
        int n = word.length();
        
        memo = new Integer[n][27][27];
        return solve(word, 0, 26, 26);
    }
    
    private int solve(String word, int idx, int f1, int f2) {
       
        if (idx == word.length()) {
            return 0;
        }
        
        if (memo[idx][f1][f2] != null) {
            return memo[idx][f1][f2];
        }
        
        int nextChar = word.charAt(idx) - 'A';
        
    
        int moveF1 = getDist(f1, nextChar) + solve(word, idx + 1, nextChar, f2);
        
     
        int moveF2 = getDist(f2, nextChar) + solve(word, idx + 1, f1, nextChar);
        
        return memo[idx][f1][f2] = Math.min(moveF1, moveF2);
    }
    
    private int getDist(int from, int to) {
        if (from == 26) return 0; 
        
        int x1 = from / 6, y1 = from % 6;
        int x2 = to / 6, y2 = to % 6;
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}