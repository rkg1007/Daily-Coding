class Solution {
    
    public boolean isValid(int[][] vis, int x, int y) {
        if (x >= 0 && x < vis.length) {
            if (y >= 0 && y < vis[0].length) {
                return vis[x][y] == 0;
            }
        }
        return false;
    }
    
    public void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public int dfs(int[][] matrix, int x, int y, int[][] vis, int[][] dp, int lastVal) {
        if (matrix[x][y] <= lastVal) return 0;
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            vis[x][y] = 1;
            int[][] steps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            for (int[] step : steps) {
                int newX = x + step[0], newY = y + step[1];
                if (isValid(vis, newX, newY)) {
                    dp[x][y] = Math.max(dp[x][y], dfs(matrix, newX, newY, vis, dp, matrix[x][y]));
                }
            }
            dp[x][y] += 1;
            vis[x][y] = 0;
        }
        
        return dp[x][y];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int[][] vis = new int[m][n];
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, vis, dp, -1));
            }
        }
        
        // print(dp);
        return ans;
    }
}