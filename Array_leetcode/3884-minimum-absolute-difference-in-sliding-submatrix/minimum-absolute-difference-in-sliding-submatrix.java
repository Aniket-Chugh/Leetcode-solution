import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                List<Integer> list = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }

                Collections.sort(list);

                int minDiff = Integer.MAX_VALUE;

                for (int t = 1; t < list.size(); t++) {
                    // 🔥 skip same values
                    if (list.get(t).equals(list.get(t - 1))) continue;

                    minDiff = Math.min(minDiff, list.get(t) - list.get(t - 1));
                }

                // 🔥 if all values same → no valid pair
                if (minDiff == Integer.MAX_VALUE) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = minDiff;
                }
            }
        }

        return ans;
    }
}