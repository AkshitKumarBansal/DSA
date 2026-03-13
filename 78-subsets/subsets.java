class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, result, list);
        return result;
    }
    private void solve(int[] arr, int ind, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++) {
            list.add(arr[i]);
            solve(arr, i+1, result, list);
            list.remove(list.size()-1);
        }
    }
}