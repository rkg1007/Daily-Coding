class Solution {
    
    public boolean isValid(int[][] matrix, int x, int y) {
        if (x >= 0 && x < matrix.length) {
            if (y >= 0 && y < matrix[0].length) {
                return true;
            }
        }
        return false;
    }
    
    public int dfs(int[][] matrix, int x, int y, int[][] dp, int lastVal) {
        if (matrix[x][y] <= lastVal) return 0;
        if (dp[x][y] == 0) {
            int[][] steps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
            for (int[] step : steps) {
                int newX = x + step[0], newY = y + step[1];
                if (isValid(matrix, newX, newY)) {
                    dp[x][y] = Math.max(dp[x][y], dfs(matrix, newX, newY, dp, matrix[x][y]) + 1);
                }
            }
        }
        
        return dp[x][y];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
       
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, 0);
        
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp, -1));
            }
        }
        
        // print(dp);
        return ans;
    }
}