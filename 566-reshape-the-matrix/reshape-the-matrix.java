class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c) return mat;
        int x=0,y=0;
        int[][] matrix = new int[r][c];
        int[] arr = new int[mat.length*mat[0].length];
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                arr[x++] = mat[i][j];
            }
        }
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                matrix[i][j] = arr[y++];
            }
        }
        return matrix;
    }
}