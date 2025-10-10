class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] rowL = new int[n];
        int[] upperDia = new int[2*n-1];
        int[] lowerDia = new int[2*n-1];
        solve(0, n, res, rowL, upperDia, lowerDia, new ArrayList<>());
        return res;
    }
    private static void solve(int col, int n, List<List<String>> res, int[] rowL, int[] upperDia, int[] lowerDia, List<String> list) {
        if(col == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int row=0;row<n;row++) {
            if(rowL[row]==0 && upperDia[n-1+col-row]==0 && lowerDia[row+col]==0) {
                char[] rowArr = new char[n];
                Arrays.fill(rowArr, '.');
                rowArr[row] = 'Q';
                String rowString = new String(rowArr);
                list.add(rowString);
                rowL[row] = 1;
                upperDia[n-1-row+col] = 1;
                lowerDia[row+col] = 1;
                solve(col+1, n, res, rowL, upperDia, lowerDia, list);
                list.remove(list.size()-1);
                rowL[row] = 0;
                upperDia[n-1+col-row] = 0;
                lowerDia[row+col] = 0;
            }
        }
    }
}