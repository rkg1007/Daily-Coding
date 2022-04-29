class Solution {
    public boolean isValid(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length) {
            if (y >= 0 && y < grid[0].length) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasValidPath(int[][] grid, boolean[][] vis, int[] curr) {
        int x = curr[0], y = curr[1];
        if (x == grid.length -1 && y == grid[0].length -1) return true;
        if (vis[x][y]) return false;
        vis[x][y] = true;
        int[][] possibleSteps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] currVals = {{1, 4, 6}, {2, 3, 4}, {2, 5, 6}, {1, 3, 5}};
        int[][] nextVals = {{1, 3, 5}, {2, 5, 6}, {2, 3, 4}, {1, 4, 6}};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + possibleSteps[i][0], newY = y + possibleSteps[i][1];
            if (isValid(grid, newX, newY)) {
                boolean currVal = false, nextVal = false;
                for (int val : currVals[i]) 
                    currVal = currVal || grid[x][y] == val;
                for (int val : nextVals[i]) 
                    nextVal = nextVal || grid[newX][newY] == val;
                if (currVal && nextVal) {
                    if (hasValidPath(grid, vis, new int[]{newX, newY})) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean hasValidPath(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        return hasValidPath(grid, vis, new int[]{0, 0});
    }
}