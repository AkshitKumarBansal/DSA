class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        subSequence(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    // private static void subSequence(int ind, int[] arr, int target, Set<List<Integer>> res, List<Integer> list) {
        // if(ind == arr.length) {
        //     if(target == 0) {
                // res.add(new ArrayList<>(list));  // Time limit exceeded
        //     }
        //     return;
        // }
        // if(arr[ind] <= target) {
        //     list.add(arr[ind]);
        //     subSequence(ind+1, arr, target-arr[ind], res, list);
        //     list.remove(list.size()-1);
        // }
        // subSequence(ind+1, arr, target, res, list);
    // }
    private static void subSequence(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<arr.length;i++) {
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            list.add(arr[i]);
            subSequence(i+1, arr, target-arr[i], ans, list);
            list.remove(list.size()-1);
        }
    }
}