class Solution {
    int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(board, i, j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0 -> 1
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) { // 1 -> 0
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private void update(int[][] board, int i, int j) {
        int n = board.length, m = board[0].length;
        int live = 0;
        for (int k = 0; k < 8; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                if (board[xx][yy] == 1 || board[xx][yy] == 3) 
                    live++;
            }
        }
        
        // curr live
        if (board[i][j] == 1) {
            if (live < 2 || live > 3) board[i][j] = 3;
        } else {
            if (live == 3) board[i][j] = 2;
        }
    }
}