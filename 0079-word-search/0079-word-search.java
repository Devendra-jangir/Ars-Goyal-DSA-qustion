class Solution {
    public boolean exist(char[][] board, String word) {
        // Iterate over each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If we find a valid path for the word starting from this cell, return true
                if (isdfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        // If no valid path is found, return false
        return false;
    }

    public boolean isdfs(char[][] board, int i, int j, String word, int index) {
        // Base case: if index equals word length, all characters have been found
        if (index == word.length()) {
            return true;
        }

        // Boundary conditions: check if i and j are within bounds and if the current cell matches the current character in the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '*';

        // Explore all possible directions: right, down, left, up
        boolean found = isdfs(board, i + 1, j, word, index + 1) ||
                        isdfs(board, i, j + 1, word, index + 1) ||
                        isdfs(board, i - 1, j, word, index + 1) ||
                        isdfs(board, i, j - 1, word, index + 1);

        // Restore the original value in the board
        board[i][j] = temp;

        return found;
    }
}
