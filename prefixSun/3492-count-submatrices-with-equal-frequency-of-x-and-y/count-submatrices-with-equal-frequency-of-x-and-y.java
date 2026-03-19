import java.util.*;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] val = new int[m][n];
        int[][] xGrid = new int[m][n];

        // Convert grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') {
                    val[i][j] = 1;
                    xGrid[i][j] = 1;
                } else if (grid[i][j] == 'Y') {
                    val[i][j] = -1;
                }
            }
        }

        // Prefix sum
        int[][] ps = new int[m + 1][n + 1];
        int[][] px = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = val[i - 1][j - 1]
                        + ps[i - 1][j]
                        + ps[i][j - 1]
                        - ps[i - 1][j - 1];

                px[i][j] = xGrid[i - 1][j - 1]
                        + px[i - 1][j]
                        + px[i][j - 1]
                        - px[i - 1][j - 1];
            }
        }

        int result = 0;

        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {

                // 👇 IMPORTANT: must include (0,0)
                if (r1 != 0 || c1 != 0) continue;

                for (int r2 = r1; r2 < m; r2++) {
                    for (int c2 = c1; c2 < n; c2++) {

                        int sum = ps[r2 + 1][c2 + 1]
                                - ps[r1][c2 + 1]
                                - ps[r2 + 1][c1]
                                + ps[r1][c1];

                        int xCount = px[r2 + 1][c2 + 1]
                                - px[r1][c2 + 1]
                                - px[r2 + 1][c1]
                                + px[r1][c1];

                        if (sum == 0 && xCount > 0) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }
}