class Solution {
    
    public int addPaths(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length) {
            if (y >= 0 && y < grid[0].length) {
                if (grid[x][y] != -1) return grid[x][y];
            }
        }
        return 0;
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        grid[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                } else {
                    grid[i][j] += addPaths(grid, i - 1, j) + addPaths(grid, i, j - 1);
                }
            }
        }
        return Math.max(0, grid[m - 1][n - 1]);
    }
}