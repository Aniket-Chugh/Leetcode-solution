import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        int[][] directions = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Found a land cell ('1')
                if (grid[i][j] == '1') {
                    count++; // New island found
                    grid[i][j] = '0'; // mark visited

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];

                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; 
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
