class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int k = 0; k < 4; k++) {  

           
            boolean match = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        match = false;
                        break;
                    }
                }
                if (!match) break;
            }

            if (match) return true;

          
            int[][] rotated = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rotated[i][j] = mat[n - j - 1][i];
                }
            }

            
            mat = rotated;
        }

        return false;
    }
}
