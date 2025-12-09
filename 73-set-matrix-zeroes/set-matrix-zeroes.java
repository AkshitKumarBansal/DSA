class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            ans[i] = matrix[i].clone();
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    Arrays.fill(ans[i], 0);
                    for(int k=0;k<matrix.length;k++) {
                        ans[k][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = ans[i].clone();
        }
    }
}