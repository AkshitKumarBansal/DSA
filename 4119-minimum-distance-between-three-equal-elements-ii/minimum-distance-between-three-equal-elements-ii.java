class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> x : map.entrySet()) {
            int key = x.getKey();
            List<Integer> list = x.getValue();
            if(list.size()>=3) {
                int sum = 0;
                for(int i=0;i<list.size()-2;i++) {
                    sum = Math.abs(list.get(i)-list.get(i+1)) + Math.abs(list.get(i+2)-list.get(i+1)) + Math.abs(list.get(i)-list.get(i+2));
                    min = Math.min(sum, min);
                }
            }
        }
        return (min==Integer.MAX_VALUE) ? -1 : min;
    }
}