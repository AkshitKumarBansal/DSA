class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for(int row=0;row<9;row++) {
            for(int col=0;col<9;col++) {
                if(board[row][col]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(check(row, col, board, ch)) {
                            board[row][col] = ch;
                            if(solve(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean check(int row, int col, char[][] board, char ch) {
        for(int i=0;i<9;i++) {
            if(board[row][i] == ch) return false;
            if(board[i][col] == ch) return false;
            if(board[(3*(row/3))+(i/3)][(3*(col/3))+(i%3)] == ch) return false;
        }
        return true;
    }
}