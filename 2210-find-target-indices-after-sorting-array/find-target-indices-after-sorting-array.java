class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int min = 0;
        int count = 0;
        for(int num : nums) {
            if(num<target) min++;
            else if(num==target) count++;
        }
        while(count!=0) {
            list.add(min);
            min++;
            count--;
        }
        return list;
    }
}