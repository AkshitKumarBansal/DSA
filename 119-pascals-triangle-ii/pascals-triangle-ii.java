class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        if(rowIndex == 0) return list1;
        for(int i=1;i<=rowIndex;i++) {
            List<Integer> list2 = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0) {
                    list2.add(list1.get(j));
                } else if(j==i) {
                    list2.add(list1.get(j-1));
                } else {
                    list2.add(list1.get(j)+list1.get(j-1));
                }
            }
            list1.clear();
            list1.addAll(list2);
        }
        return list1;
    }
}