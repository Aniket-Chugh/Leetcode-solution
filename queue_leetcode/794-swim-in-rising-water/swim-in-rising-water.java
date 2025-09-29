import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxH = Math.max(maxH, grid[i][j]);
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int t = 0; t <= maxH; t++) {
            if (grid[0][0] > t) continue;
            boolean[][] vis = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});
            vis[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) return t;
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !vis[nx][ny] && grid[nx][ny] <= t) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
