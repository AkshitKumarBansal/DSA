class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(new boolean[nums.length], nums, result, new ArrayList<>());
        return result;
    }
    private void solve(boolean[] used, int[] nums, List<List<Integer>> result, List<Integer> list) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                solve(used, nums, result, list);
                list.remove(list.size()-1);
                used[i] = false;;
            }
        }
    }
}