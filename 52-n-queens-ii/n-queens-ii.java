class Solution {
    public int totalNQueens(int n) {
       List<List<String>> res = new ArrayList<>();
       int[] row = new int[n];
       int[] upperDia = new int[2*n-1];
       int[] lowerDia = new int[2*n-1];
       Yes(n, 0, row, upperDia, lowerDia, res, new ArrayList<>());
       return res.size(); 
    }
    private void Yes(int n, int col, int[] row, int[] upperDia, int[] lowerDia, List<List<String>> res, List<String> list) {
        if(col == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++) {
            if(row[i]==0 && upperDia[i+col]==0 && lowerDia[n-1-i+col]==0) {
                char rowArr[] = new char[n];
                Arrays.fill(rowArr, '.');
                list.add(new String(rowArr));
                row[i] = 1;
                upperDia[i+col] = 1;
                lowerDia[n-1-i+col] = 1;
                Yes(n, col+1, row, upperDia, lowerDia, res, list);
                row[i] = 0;
                upperDia[i+col] = 0;
                lowerDia[n-1-i+col] = 0;
            }
        }
    }
}