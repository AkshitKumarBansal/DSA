class Solution {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[j]%nums[i]==0) {
                    map.get(nums[i]).add(nums[j]);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i : nums) {
            List<Integer> curr = solve(i, map);
            if(curr.size()>result.size()) result = curr;
        }
        return result;
    }
    private List<Integer> solve(int num, Map<Integer, List<Integer>> map) {
        if(memo.containsKey(num)) {
            return new ArrayList<>(memo.get(num));
        }
        List<Integer> ans = new ArrayList<>();
        for(int node : map.get(num)) {
            List<Integer> curr = solve(node, map);
            if(curr.size()>ans.size()) ans = curr;
        }
        List<Integer> result = new ArrayList<>();
        result.add(num);
        result.addAll(ans);
        memo.put(num, result);
        return result;
    }
}