class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(new ArrayList<>(list));
        for(int i=1;i<numRows;i++) {
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i) res.add(1);
                else res.add(list.get(j-1)+list.get(j));
            }
            list = new ArrayList<>(res);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}