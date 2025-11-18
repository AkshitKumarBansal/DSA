class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(new ArrayList<>(list1));
        if (numRows == 1) {
            return res;
        }
        for(int i=1;i<numRows;i++) {
            List<Integer> list2 = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j == i) {
                    list2.add(list1.get(j-1));
                } else if(j == 0) {
                    list2.add(list1.get(j));
                } else {
                    list2.add(list1.get(j)+list1.get(j-1));
                }
            }
            res.add(new ArrayList<>(list2));
            list1.clear();
            list1.addAll(list2);
        }
        return res;
    }
}