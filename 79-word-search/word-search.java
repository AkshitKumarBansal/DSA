class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] arr = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(dfs(board, i, j, 0, word, arr)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, int k, String word, boolean[][] arr) {
        if(k==word.length()) return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || arr[i][j] || board[i][j]!=word.charAt(k)) return false;
        arr[i][j] = true;
        boolean flag =
            dfs(board, i-1, j, k+1, word, arr) || 
            dfs(board, i, j-1, k+1, word, arr) ||
            dfs(board, i, j+1, k+1, word, arr) ||
            dfs(board, i+1, j, k+1, word, arr);
        arr[i][j] = false;

        return flag;
    }
}