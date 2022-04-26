class Solution {
    public boolean isValid(int[][] matrix, int x, int y) {
        if (x >= 0 && x < matrix.length) {
            if (y >= 0 && y < matrix[0].length) {
                return true;
            }
        }
        return false;
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int pathSum = 0, flag = 0;
                if (isValid(dungeon, i + 1, j)) {
                    pathSum = Math.min(0, dungeon[i + 1][j]);
                    flag = 1;
                }
                if (isValid(dungeon, i, j + 1)) {
                    if (flag == 1) pathSum = Math.max(pathSum, Math.min(0, dungeon[i][j + 1]));
                    else pathSum = Math.min(0, dungeon[i][j + 1]);
                }
                dungeon[i][j] += pathSum;
            }
        }
        
        if (dungeon[0][0] <= 0) {
            return dungeon[0][0] * -1 + 1;
        }
        return 1;
    }
}