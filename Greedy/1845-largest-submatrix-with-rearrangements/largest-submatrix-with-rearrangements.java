import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {

            
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            
            int[] sorted = height.clone();
            Arrays.sort(sorted);

            
            for (int j = n - 1; j >= 0; j--) {
                int h = sorted[j];
                int width = n - j;  
                int area = h * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}