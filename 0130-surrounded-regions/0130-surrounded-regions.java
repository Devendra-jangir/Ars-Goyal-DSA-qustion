class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'v') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 'O') {
            return;
        }
        arr[i][j] = 'v'; 
        dfs(arr, i + 1, j);
        dfs(arr, i, j + 1);
        dfs(arr, i - 1, j);
        dfs(arr, i, j - 1);
    }
}
