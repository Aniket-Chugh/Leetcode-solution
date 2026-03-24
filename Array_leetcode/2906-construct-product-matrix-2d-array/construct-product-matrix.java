class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int size = n * m;
        int[] arr = new int[size];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[k++] = grid[i][j] % mod;
            }
        }

        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (int)((long)prefix[i - 1] * arr[i - 1] % mod);
        }

        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (int)((long)suffix[i + 1] * arr[i + 1] % mod);
        }

        int[][] result = new int[n][m];
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (int)((long)prefix[k] * suffix[k] % mod);
                k++;
            }
        }

        return result;
    }
}
