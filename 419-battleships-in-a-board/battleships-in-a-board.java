class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='.') continue;
                if(i>0 && board[i][j]==board[i-1][j] && board[i][j]=='X') continue;
                if(j>0 && board[i][j]==board[i][j-1] && board[i][j]=='X') continue;
                count++;
            }
        }
        return count;
    }
}