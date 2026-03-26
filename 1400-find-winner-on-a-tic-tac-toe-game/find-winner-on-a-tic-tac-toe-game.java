class Solution {
    public String tictactoe(int[][] moves) {
        int[][] arr = new int[3][3];
        int n = moves.length;
        for(int i=0;i<n;i++) {
            if(i%2==0) {
                arr[moves[i][0]][moves[i][1]] = 1;
            } else {
                arr[moves[i][0]][moves[i][1]] = -1;
            }
        }
        for (int i = 0; i < 3; i++) {
            int rowSum = arr[i][0] + arr[i][1] + arr[i][2];
            int colSum = arr[0][i] + arr[1][i] + arr[2][i];
            
            if (rowSum == 3 || colSum == 3) return "A";
            if (rowSum == -3 || colSum == -3) return "B";
        }
        int diag1 = arr[0][0] + arr[1][1] + arr[2][2];
        int diag2 = arr[0][2] + arr[1][1] + arr[2][0];

        if(diag1==3 || diag2==3) return "A";
        if(diag1==-3 || diag2==-3) return "B";

        return (n==9) ? "Draw" : "Pending";
        
    }
}