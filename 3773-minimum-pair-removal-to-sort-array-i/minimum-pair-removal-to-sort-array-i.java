class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        if (list.size() < 2) return 0;
        boolean check = isSorted(list);
        while(!check && !list.isEmpty()) {
            int min = list.get(1)+list.get(0);
            int x = 0;
            int y = 1;
            for(int i=1;i<list.size()-1;i++) {
                if(min>list.get(i)+list.get(i+1)){
                    min = list.get(i)+list.get(i+1);
                    x = i;
                    y = i+1;
                }
            }
            list.remove(y);
            list.remove(x);
            list.add(x, min);
            count++;
            check = isSorted(list);
        }
        return count;
        
    }
    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}