class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();
        List<Integer> list = new ArrayList<>();
        for(int i=min;i<=max;i++) {
            for(int j=0;i+j<=9;j++) {
                int num = Integer.parseInt(s.substring(j, i+j));
                if(num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        return list;
    }
}