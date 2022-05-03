class Solution {
    public boolean isValid(char[][] board, int x, int y) {
        if (x >= 0 && x < board.length) {
            if (y >= 0 && y < board[0].length) {
                return board[x][y] == 'O';
            }
        }
        return false;
    }
    
    public void bfs(char[][] board, boolean[][] unCaptured, int[] currPos) {
        int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        LinkedList<int[]> stk = new LinkedList<>();
        stk.addLast(currPos);
        while (stk.size() > 0) {
            currPos = stk.removeLast();
            int x = currPos[0], y = currPos[1];
            unCaptured[x][y] = true;
            for (int[] step : steps) {
                int newX = x + step[0], newY = y + step[1];
                if (isValid(board, newX, newY)) {
                    if (!unCaptured[newX][newY])
                        stk.addLast(new int[]{newX, newY});
                }
            }
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] unCaptured = new boolean[m][n];
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, unCaptured, new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                bfs(board, unCaptured, new int[]{m - 1, j});
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (board[j][0] == 'O') {
                bfs(board, unCaptured, new int[]{j, 0});
            }
            if (board[j][n - 1] == 'O') {
                bfs(board, unCaptured, new int[]{j, n - 1});
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!unCaptured[i][j]) board[i][j] = 'X';
            }
        }
    }
}